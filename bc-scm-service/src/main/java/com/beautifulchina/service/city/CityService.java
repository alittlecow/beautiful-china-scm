/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-06
 */
package com.beautifulchina.service.city;


import com.beautifulchina.bean.FileParam;
import com.beautifulchina.city.bo.CityBO;
import com.beautifulchina.city.bo.CityDeletePhotoBO;
import com.beautifulchina.city.pojo.City;
import com.beautifulchina.city.vo.CityDeletePhotoVO;
import com.beautifulchina.city.vo.CityVO;
import com.beautifulchina.common.Page;
import com.beautifulchina.dao.city.CityMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.service.destination.DestinationService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.FileUploadUtil;
import com.beautifulchina.util.ReflectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 城市管理
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class CityService {
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private CityMapper cityMapper;

    private static final String SAVEPATH = "/upload/city/";

    /**
     * 根据条件获取所有城市列表
     *
     * @param
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<CityBO> getAllCityList(CityVO cityVO) {
        CityBO cityBO = new CityBO();
        BeanUtils.copyProperties(cityVO, cityBO);
        int count = cityMapper.getAllCityListCount(cityBO);
        List<CityBO> cityBOList = new ArrayList<CityBO>();
        if (count > 0) {
            List<City> cities = cityMapper.getAllCityList(cityBO);
            for (City city : cities) {
                CityBO cityBo = new CityBO();
                BeanUtils.copyProperties(city, cityBo);
                cityBOList.add(cityBo);
            }
        }
        Page<CityBO> page = new Page<CityBO>();
        page.setData(cityBOList);
        page.setTotal(count);
        return page;
    }

    /**
     * 保存城市信息
     */
    public void saveCity(UserBO userBO, HttpServletRequest request, String serverPath) throws RedisException,
            InstantiationException, IllegalAccessException, IOException {

        //文件保存目录
        String savePath = SAVEPATH + userBO.getUsername();
        //获取FileItem集合
        List<FileItem> list = FileUploadUtil.getFileItem(request);
        //设置入参值
        FileParam<CityVO> fileParam = FileUploadUtil.convertFileItem(list, CityVO.class);
        CityVO cityVO = fileParam.getForm();
        //保存文件
        List<String> filePaths = FileUploadUtil.saveFile(serverPath, savePath, fileParam);
        destinationService.scalePhoto(filePaths);
        CityBO cityBO = new CityBO();
        BeanUtils.copyProperties(cityVO, cityBO);
        cityBO.setOperateTime(new Date());
        cityMapper.save(cityBO);
    }

    /**
     * 更新城市信息
     *
     * @param userBO,request
     */
    public void updateCity(UserBO userBO, HttpServletRequest request, String serverPath) throws RedisException,
            InstantiationException, IllegalAccessException, IOException {
        //文件保存目录
        String savePath = SAVEPATH + userBO.getUsername();
        //获取FileItem集合
        List<FileItem> list = FileUploadUtil.getFileItem(request);
        //设置入参值
        FileParam<CityVO> fileParam = FileUploadUtil.convertFileItem(list, CityVO.class);
        CityVO cityVO = fileParam.getForm();
        //保存文件
        List<String> filePaths = FileUploadUtil.saveFile(serverPath, savePath, fileParam);
        destinationService.scalePhoto(filePaths);
        CityBO cityBO = new CityBO();
        BeanUtils.copyProperties(cityVO, cityBO);
        cityBO.setOperateTime(new Date());
        cityBO.setOperator(userBO.getUsername());
        //获得更新前4张图片的图片名称
        String id = cityBO.getCityId() + "";
        List<String> listId = new ArrayList<String>();
        listId.add(id);
        List<Map<String, String>> oldPhotosList = cityMapper.getPhotoNameById(listId);
        Map<String, String> oldPhotosMap = oldPhotosList.get(0);//获得更新前4张图片的图片名称存在此map里面

        //cityBO,里的信息,如果图片1到4为空的,代表图片没有改变,如果不为空,则去服务器的图片库删掉以前存储的图片
        if (cityBO.getPhotoOne() != null) {
            String path = oldPhotosMap.get("photo_one");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }
        if (cityBO.getPhotoTwo() != null) {
            String path = oldPhotosMap.get("photo_two");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }
        if (cityBO.getPhotoThree() != null) {
            String path = oldPhotosMap.get("photo_three");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }
        if (cityBO.getPhotoFour() != null) {
            String path = oldPhotosMap.get("photo_four");
            if (path != null) {
                destinationService.deleteFiles(serverPath + path, serverPath + destinationService.getExtraName(path, DestinationService.PHOTOSIZE));
            }
        }

        cityMapper.update(cityBO);
    }

    /**
     * 根据编号删除城市信息
     *
     * @param cityIds
     */
    public void deleteCityById(String cityIds, HttpServletRequest request, String savePath) {
        List<String> cityIdList = CollectionUtils.arrayToList(cityIds.split(","));
        List<Map<String, String>> photoMap = cityMapper.getPhotoNameById(cityIdList);
        //删除图片
        destinationService.delPhotoMap(photoMap, savePath);

        //删除数据库信息
        cityMapper.delete(cityIdList);
    }

    public void delPhoto(CityDeletePhotoVO cityDeletePhotoVO, HttpServletRequest request, String serverPath)
            throws IllegalAccessException, InstantiationException {
        Object obj = CityDeletePhotoBO.class.newInstance();
        ReflectionUtils.setFieldValue(obj, cityDeletePhotoVO.getPhotoName(), cityDeletePhotoVO.getSavePath());
        CityDeletePhotoBO cityDeletePhotoBO = (CityDeletePhotoBO) obj;
        cityDeletePhotoBO.setId(cityDeletePhotoVO.getId());
        cityMapper.updPhoto(cityDeletePhotoBO);
        String path1 = serverPath + cityDeletePhotoVO.getSavePath();
        String path2 = destinationService.getExtraName(path1, DestinationService.PHOTOSIZE);
        destinationService.deleteFiles(path1, path2);

    }
}












