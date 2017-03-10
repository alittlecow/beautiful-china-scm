/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.service.linetheme;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.bean.FileParam;
import com.beautifulchina.dao.linetheme.LineThemeMapper;
import com.beautifulchina.destination.bo.DestinationBO;
import com.beautifulchina.destination.pojo.Destination;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.linetheme.bo.LineThemeBO;
import com.beautifulchina.linetheme.bo.LineThemeDeletePhotoBO;
import com.beautifulchina.linetheme.pojo.LineTheme;
import com.beautifulchina.linetheme.vo.LineThemeDeletePhotoVO;
import com.beautifulchina.linetheme.vo.LineThemeVO;
import com.beautifulchina.main.bo.LineThemeListBO;
import com.beautifulchina.service.destination.DestinationService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.FileUploadUtil;
import com.beautifulchina.util.ReflectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.beautifulchina.common.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 线路主题管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LineThemeService {
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private LineThemeMapper linethemeMapper;

    private static final String SAVEPATH = "/upload/lineTheme/";

    /**
     * 根据条件获取所有线路主题信息
     *
     * @param linethemeVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<LineThemeListBO> getAllLineThemeList(LineThemeVO linethemeVO) {
        LineThemeBO linethemeBO = new LineThemeBO();
        BeanUtils.copyProperties(linethemeVO, linethemeBO);
        int count = linethemeMapper.getAllLineThemeListCount(linethemeBO);
        List<LineThemeListBO> linethemeListBOList = new ArrayList<LineThemeListBO>();
        Page<LineThemeListBO> linethemeListBOPage = new Page<LineThemeListBO>();
        if (count > 0) {
            List<LineTheme> linethemeList = linethemeMapper.getAllLineThemeList(linethemeBO);
            if (!CollectionUtils.isEmpty(linethemeList)) {
                for (LineTheme linetheme : linethemeList) {
                    LineThemeListBO linethemeListBO = new LineThemeListBO();
                    BeanUtils.copyProperties(linetheme, linethemeListBO);
                    linethemeListBOList.add(linethemeListBO);
                }
            }
        }
        linethemeListBOPage.setTotal(count);
        linethemeListBOPage.setData(linethemeListBOList);
        return linethemeListBOPage;
    }

    /**
     * 保存线路主题信息
     */
    public void saveLineTheme(UserBO userBO, HttpServletRequest request, String serverPath) throws RedisException,
            InstantiationException, IllegalAccessException, IOException {

        //文件保存目录
        String savePath = SAVEPATH + userBO.getUsername();
        //获取FileItem集合
        List<FileItem> list = FileUploadUtil.getFileItem(request);
        //设置入参值
        FileParam<LineThemeVO> fileParam = FileUploadUtil.convertFileItem(list, LineThemeVO.class);
        LineThemeVO linethemeVO = fileParam.getForm();
        //保存文件
        List<String> filePaths = FileUploadUtil.saveFile(serverPath, savePath, fileParam);
        destinationService.scalePhoto(filePaths);
        LineThemeBO linethemeBO = new LineThemeBO();
        BeanUtils.copyProperties(linethemeVO, linethemeBO);
        linethemeBO.setOperateTime(new Date());
        linethemeMapper.save(linethemeBO);
    }

    /**
     * 更新线路主题信息
     *
     * @param userBO,request
     */
    public void updateLineTheme(UserBO userBO, HttpServletRequest request, String serverPath) throws RedisException,
            InstantiationException, IllegalAccessException, IOException {
        //文件保存目录
        String savePath = SAVEPATH + userBO.getUsername();
        //获取FileItem集合
        List<FileItem> list = FileUploadUtil.getFileItem(request);
        //设置入参值
        FileParam<LineThemeVO> fileParam = FileUploadUtil.convertFileItem(list, LineThemeVO.class);
        LineThemeVO linethemeVO = fileParam.getForm();

        //获得更新前4张图片的图片名称
        String id = linethemeVO.getId() + "";
        List<String> listId = new ArrayList<String>();
        listId.add(id);
        List<Map<String, String>> oldPhotosList = linethemeMapper.getPhotoNameById(listId);
        Map<String, String> oldPhotosMap = oldPhotosList.get(0);//获得更新前4张图片的图片名称存在此map里面

        //保存文件
        List<String> filePaths = FileUploadUtil.saveFile(serverPath, savePath, fileParam);
        destinationService.scalePhoto(filePaths);
        LineThemeBO linethemeBO = new LineThemeBO();
        BeanUtils.copyProperties(linethemeVO, linethemeBO);
        linethemeBO.setOperateTime(new Date());
        linethemeBO.setOperator(userBO.getUsername());
        linethemeMapper.update(linethemeBO);

        //查询linethemeBO,里的信息,如果图片1到4为空的,代表图片没有改变,如果不为空,则去服务器的图片库删掉以前存储的图片
        if (linethemeBO.getPhotoOne() != null) {
            String path = oldPhotosMap.get("photo_one");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }
        if (linethemeBO.getPhotoTwo() != null) {
            String path = oldPhotosMap.get("photo_two");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }
        if (linethemeBO.getPhotoThree() != null) {
            String path = oldPhotosMap.get("photo_three");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }
        if (linethemeBO.getPhotoFour() != null) {
            String path = oldPhotosMap.get("photo_four");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }
    }

    /**
     * 根据编号删除线路主题信息
     *
     * @param ids
     */
    public void deleteLineThemeById(String ids, HttpServletRequest request, String savePath) {
        List<String> idsList = CollectionUtils.arrayToList(ids.split(","));
        List<Map<String, String>> photoMap = linethemeMapper.getPhotoNameById(idsList);
        //删除图片
        destinationService.delPhotoMap(photoMap, savePath);

        //删除数据库信息
        linethemeMapper.delete(idsList);
    }

    public void delPhoto(LineThemeDeletePhotoVO lineThemeDeletePhotoVO, HttpServletRequest request, String serverPath) throws IllegalAccessException, InstantiationException {
        Object obj = LineThemeDeletePhotoBO.class.newInstance();
        ReflectionUtils.setFieldValue(obj, lineThemeDeletePhotoVO.getPhotoName(), lineThemeDeletePhotoVO.getSavePath());
        LineThemeDeletePhotoBO lineThemeDeletePhotoBO = (LineThemeDeletePhotoBO) obj;
        lineThemeDeletePhotoBO.setId(lineThemeDeletePhotoVO.getId());
        linethemeMapper.updPhoto(lineThemeDeletePhotoBO);
        String path1 = serverPath + lineThemeDeletePhotoVO.getSavePath();
        String path2 = destinationService.getExtraName(path1, DestinationService.PHOTOSIZE);
        destinationService.deleteFiles(path1, path2);
    }

}
