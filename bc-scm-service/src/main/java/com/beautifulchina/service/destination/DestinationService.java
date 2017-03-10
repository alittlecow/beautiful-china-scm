/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-07
 */
package com.beautifulchina.service.destination;

import com.alibaba.fastjson.JSONObject;
import com.beautifulchina.base.BaseService;
import com.beautifulchina.base.Page;
import com.beautifulchina.bean.FileParam;
import com.beautifulchina.dao.destination.DestinationMapper;
import com.beautifulchina.destination.bo.DestinationBO;
import com.beautifulchina.destination.bo.DestinationDeletePhotoBO;
import com.beautifulchina.destination.pojo.Destination;
import com.beautifulchina.destination.vo.DestinationDeletePhotoVO;
import com.beautifulchina.destination.vo.DestinationDeleteVO;
import com.beautifulchina.destination.vo.DestinationVO;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.FileUploadUtil;
import com.beautifulchina.util.ImageUtil;
import com.beautifulchina.util.ReflectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

/**
 * 目的地管理业务相关
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DestinationService extends BaseService {


    @Autowired
    private DestinationMapper destinationMapper;
    /**
     * 图片服务器地址
     */
    @Value("${image.server}")
    private String imageServer;
    private static final String SAVEPATH = "/upload/destination/";
    public static final String PHOTOSIZE = "1800_700_";

    /**
     * 获取目的地信息
     *
     * @param destinationVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<DestinationBO> getDestination(DestinationVO destinationVO) {
        Page<DestinationBO> page = new Page<DestinationBO>();
        List<DestinationBO> list = new ArrayList<DestinationBO>();
        DestinationBO destinationBO = new DestinationBO();
        BeanUtils.copyProperties(destinationVO, destinationBO);
        int count = destinationMapper.getCount(destinationBO);
        if (count > 0) {
            List<Destination> destinationList = destinationMapper.getDestination(destinationBO);
            if (!CollectionUtils.isEmpty(destinationList)) {
                for (Destination destination : destinationList) {
                    DestinationBO destinationBO1 = new DestinationBO();
                    BeanUtils.copyProperties(destination, destinationBO1);
                    list.add(destinationBO1);
                }
                page.setData(list);
                page.setTotal(count);
            }
        }
        return page;
    }

    /**
     * 根据id删除目的地信息
     *
     * @param destinationDeleteVO
     */
    public void delDestination(DestinationDeleteVO destinationDeleteVO, String savePath) {
        List<Map<String, String>> photoMap = destinationMapper.getPhotoNameById(destinationDeleteVO.getIds());
        destinationMapper.delDestination(destinationDeleteVO.getIds());
        //删除图片
        delPhotoMap(photoMap, savePath);
    }

    /**
     * 删除图片
     *
     * @param photoMap
     * @param savePath
     */
    public void delPhotoMap(List<Map<String, String>> photoMap, String savePath) {
        if (photoMap != null) {
            for (Map<String, String> map : photoMap) {
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String fileName = entry.getValue();
                        if (fileName != null && !"".equals(fileName)) {
                            String filePath = savePath + "/" + fileName;
                            String filePath1 = getExtraName(filePath, PHOTOSIZE);
                            deleteFiles(filePath, filePath1);
                        }
                    }
                }
            }
        }
    }

    /**
     * 新增目的地信息
     *
     * @param userBO user信息
     * @throws RedisException
     */
    public void addDestination(UserBO userBO, HttpServletRequest request, String serverPath, String local) throws Exception {

        //文件保存目录
        String savePath = SAVEPATH + userBO.getUsername();

        //获取FileItem集合
        List<FileItem> list = FileUploadUtil.getFileItem(request);

        //设置入参值
        FileParam<DestinationBO> fileParam = FileUploadUtil.convertFileItem(list, DestinationBO.class);
        DestinationBO destinationBO = fileParam.getForm();

        //保存文件
        List<String> filePaths = FileUploadUtil.saveFile(serverPath, savePath, fileParam);

        //处理图片，进行缩放
        scalePhoto(filePaths);

        //保存多语言参数，并获取多语言相关参数uuid值
        DestinationBO newDestinationBO = (DestinationBO) getMultiLanguage(DestinationBO.class, destinationBO.getMultiLanguage(), local);

        //设置入参多语言字段uuid值
        destinationBO.setDesc(newDestinationBO.getDesc());
        destinationBO.setTitle(newDestinationBO.getTitle());

        //存入数据库
        destinationMapper.addDestination(destinationBO);

    }

    /**
     * 更细目的地信息
     *
     * @param request
     * @param userBO
     */
    public void updDestination(UserBO userBO, HttpServletRequest request, String serverPath, String local) throws Exception {
        //文件保存目录
        String savePath = SAVEPATH + userBO.getUsername();

        //获取FileItem集合
        List<FileItem> list = FileUploadUtil.getFileItem(request);

        //设置入参值
        FileParam<DestinationBO> fileParam = FileUploadUtil.convertFileItem(list, Destination.class);
        DestinationBO destinationBO = fileParam.getForm();

        //保存文件
        List<String> filePaths = FileUploadUtil.saveFile(serverPath, savePath, fileParam);

        //处理图片，进行缩放
        scalePhoto(filePaths);

        /*获取原数据库图片，并对修改的图片进行删除*/

        //获取原图片地址
        List<String> listId = new ArrayList<String>();
        listId.add(destinationBO.getId().toString());
        List<Map<String, String>> oldPhotosList = destinationMapper.getPhotoNameById(listId);
        Map<String, String> oldPhotosMap = oldPhotosList.get(0);

        //判断是否有新上传图片，并删除新上传图片对应的原图片
        if (destinationBO.getPhotoOne() != null) {
            String path = oldPhotosMap.get("photo_one");
            if (path != null) {
                deleteFiles(serverPath + path, serverPath + getExtraName(path, PHOTOSIZE));
            }
        }
        if (destinationBO.getPhotoTwo() != null) {
            String path = oldPhotosMap.get("photo_two");
            if (path != null) {
                deleteFiles(serverPath + path, serverPath + getExtraName(path, PHOTOSIZE));
            }
        }
        if (destinationBO.getPhotoThree() != null) {
            String path = oldPhotosMap.get("photo_three");
            if (path != null) {
                deleteFiles(serverPath + path, serverPath + getExtraName(path, PHOTOSIZE));
            }
        }
        if (destinationBO.getPhotoFour() != null) {
            String path = oldPhotosMap.get("photo_four");
            if (path != null) {
                deleteFiles(serverPath + path, serverPath + getExtraName(path, PHOTOSIZE));
            }
        }

        //根据id删除原多语言配置
        destinationMapper.delDestinationLanguage(destinationBO.getId());

        //保存多语言参数，并获取多语言相关参数uuid值
        DestinationBO newDestinationBO = (DestinationBO) getMultiLanguage(DestinationBO.class, destinationBO.getMultiLanguage(), local);

        //设置入参多语言字段uuid值
        destinationBO.setDesc(newDestinationBO.getDesc());
        destinationBO.setTitle(newDestinationBO.getTitle());

        //修改数据库信息
        destinationMapper.updDestination(destinationBO);
    }

    /**
     * 修改目的地图片信息，并删除图片
     *
     * @param destinationDeletePhotoVO
     */
    public void delPhoto(DestinationDeletePhotoVO destinationDeletePhotoVO, String serverPath) throws IllegalAccessException, InstantiationException {

        //利用反射机制获取待更新参数
        Object obj = DestinationDeletePhotoBO.class.newInstance();
        ReflectionUtils.setFieldValue(obj, destinationDeletePhotoVO.getPhotoName(), destinationDeletePhotoVO.getSavePath());
        DestinationDeletePhotoBO destinationDeletePhotoBO = (DestinationDeletePhotoBO) obj;

        destinationDeletePhotoBO.setId(destinationDeletePhotoVO.getId());
        destinationMapper.updPhoto(destinationDeletePhotoBO);

        //删除被修改图片
        String path1 = serverPath + destinationDeletePhotoVO.getSavePath();
        String path2 = getExtraName(path1, PHOTOSIZE);
        deleteFiles(path1, path2);
    }

    /**
     * 缩放图片到指定大小1800*700
     *
     * @param filePaths 图片路径
     */
    public void scalePhoto(List<String> filePaths) throws IOException {
        int width = 1800;
        int height = 700;
        if (filePaths.size() > 0) {
            String tempPath;
            for (String filePath : filePaths) {
                File f = new File(filePath);
                tempPath = getExtraName(filePath, PHOTOSIZE);
                BufferedImage bi = ImageIO.read(f);
                int diff = bi.getWidth() - width;
                if (diff <= 0) {
                    ImageUtil.scaleByRatio(filePath, tempPath, (double) width / bi.getWidth(), true);
                } else {
                    ImageUtil.scaleBySize(filePath, tempPath, height, width, false);
                }
            }
        }
    }

    /**
     * 删除文件
     *
     * @param filePath
     */
    public void deleteFiles(String... filePath) {
        if (filePath.length > 0) {
            File file;
            for (String path : filePath) {
                file = new File(path);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /**
     * 原图片加名称前缀
     *
     * @param savePath  原绝对路径
     * @param ExtraName 文件前缀
     * @return 添加前缀后的文件绝对路径
     */
    public String getExtraName(String savePath, String ExtraName) {
        return savePath.substring(0, savePath.lastIndexOf("/") + 1) + ExtraName + savePath.substring(savePath.lastIndexOf("/") + 1);
    }

    /**
     * 根据id获取多语言数据
     *
     * @param id
     * @return
     */
    public JSONObject getLanguageById(String id, String[] types) {
        DestinationBO destinationBO = new DestinationBO();
        destinationBO.setId(Integer.parseInt(id));

        JSONObject jsonObject = new JSONObject();

        //根据语言类型，获取相应的多语言值
        for (String language : types) {
            destinationBO.setLanguage(language);
            List<Map<String, String>> sysCfg = destinationMapper.getDestinationById(destinationBO);
            jsonObject.put(language, sysCfg.get(0));
        }
        return jsonObject;
    }
}
