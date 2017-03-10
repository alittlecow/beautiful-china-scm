/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-25
 */
package com.beautifulchina.service.tour;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.tour.TourMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.tour.bo.TourBO;
import com.beautifulchina.tour.bo.TourDestinationBO;
import com.beautifulchina.tour.bo.TourWayCityBO;
import com.beautifulchina.tour.pojo.Tour;
import com.beautifulchina.tour.pojo.TourOption;
import com.beautifulchina.tour.vo.TourOptionVO;
import com.beautifulchina.tour.vo.TourVO;
import com.beautifulchina.tourImage.bo.TourImageBO;
import com.beautifulchina.tourconfig.bo.TourConfigBO;
import com.beautifulchina.tourdetail.bo.TourDetailBO;
import com.beautifulchina.tourdetail.pojo.TourDetail;
import com.beautifulchina.tourdetail.vo.TourDetailVO;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.FileUploadUtil;
import com.beautifulchina.util.ImageUtil;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

import static com.beautifulchina.util.FileUploadUtil.getFileExtName;

/**
 * 线路管理相关业务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TourService {
    @Autowired
    private TourMapper tourMapper;
    private static final String SAVEPATH = "/upload/tour/";

    /**
     * 根据条件获取线路管理信息
     *
     * @param tourVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<TourBO> getTour(TourVO tourVO, UserBO userBO) {
        Page<TourBO> page = new Page<TourBO>();
        TourBO tourBO = new TourBO();
        BeanUtils.copyProperties(tourVO, tourBO);
        if ("SUPPLIER".equalsIgnoreCase(userBO.getDeptInfoBO().getLevelCode())) {
            tourBO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        }
        int count = tourMapper.getCount(tourBO);
        if (count > 0) {
            List<Tour> list = tourMapper.getTour(tourBO);
            List<TourBO> tourBOList = new ArrayList<TourBO>();
            for (Tour tour : list) {
                TourBO tourBO1 = new TourBO();
                BeanUtils.copyProperties(tour, tourBO1);
                tourBOList.add(tourBO1);
            }
            page.setData(tourBOList);
            page.setTotal(count);
        }
        return page;
    }

    /**
     * 根据id删除旅游线路管理信息
     *
     * @param id
     */
    public void deleteTour(String[] id, UserBO userBO, String serverPath) {
        List<String> list = CollectionUtils.arrayToList(id);
        //删除保存图片
        List<Map> imageUrl = tourMapper.selectImageById(list);
        String savePath = SAVEPATH + userBO.getUsername();
        File root = new File(serverPath + savePath);
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                int fileIndex = fileName.indexOf("_");
                if (fileIndex != -1) {
                    fileName = fileName.substring(fileIndex + 1);
                }
                for (Map map : imageUrl) {
                    String url = map.get("url").toString();
                    if (fileName.equals(url.substring(url.lastIndexOf("/") + 1))) {
                        file.delete();
                        break;
                    }
                }
            }
        }
        //删除数据库信息
        tourMapper.deleteTour(list);
    }

    /**
     * 获取所有行程详情
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<TourDetailBO> getTourDetail(String id) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        Page<TourDetailBO> page = new Page<TourDetailBO>();
        List<TourDetailBO> tourDetailBOList = new ArrayList<TourDetailBO>();
        int count = tourMapper.getTourDetailCount(map);
        if (count > 0) {
            List<TourDetail> tourDetailList = tourMapper.getTourDetail(map);
            for (TourDetail tourDetail : tourDetailList) {
                TourDetailBO tourDetailBO = new TourDetailBO();
                BeanUtils.copyProperties(tourDetail, tourDetailBO);
                tourDetailBOList.add(tourDetailBO);
            }
        }
        page.setData(tourDetailBOList);
        page.setTotal(count);
        return page;
    }

    /**
     * 获取供应商代码及名称
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getSup() {
        List<Map<String, String>> list = tourMapper.getSup();
        return list;
    }

    /**
     * 获取线路主题
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getTheme(String language) {
        List<Map<String, String>> list = tourMapper.getTheme(language);
        return list;
    }

    /**
     * 根据线路id获取图片地址
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map> getImageByTourId(Integer tourId) {
        List<Map> list = tourMapper.selectImageByTourId(tourId);
        return list;
    }

    /**
     * 新增旅游信息
     *
     * @param tourVO
     * @param userBO
     */
    public Integer addBaseInfo(TourVO tourVO, UserBO userBO) throws RedisException {
        TourBO tourBO = new TourBO();
        BeanUtils.copyProperties(tourVO, tourBO);
        tourBO.setOperateTime(new Date());
        tourBO.setOperator(userBO.getName());
        tourBO.setCategory(0);
        tourBO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        String levelCode = userBO.getDeptInfoBO().getLevelCode();
        if("SUPPLIER".equals(levelCode)){//判断供应商等级代码,如果是"SUPPLIER"代表供应商在操作,正在添加的是供应商的线路,否则就是平台自营线路
            tourBO.setOwner("S");
        }else{
            tourBO.setOwner("P");
        }
        //新增线路信息
        tourMapper.insertTour(tourBO);

        //新增主题
        tourMapper.insertTourTheme(tourBO);

        //新增配置
        List<TourConfigBO> configBOList = new ArrayList<TourConfigBO>();
        setConfig(configBOList, tourBO);
        tourMapper.insertTourConfig(configBOList);

        //新增目的地
        List<TourDestinationBO> destinationBOList = new ArrayList<TourDestinationBO>();
        setDestiantion(destinationBOList, tourBO);
        if (destinationBOList.size() > 0) {
            tourMapper.insertDestination(destinationBOList);
        }
        //新增途径城市
        List<TourWayCityBO> tourWayCityBOList = new ArrayList<TourWayCityBO>();
        setWayCity(tourWayCityBOList, tourBO);
        if (tourWayCityBOList.size() > 0) {
            tourMapper.insertWayCity(tourWayCityBOList);
        }
        return tourBO.getId();
    }

    /**
     * 设置新增和修改配置项入参参数值
     *
     * @param configBOList 数据库入参
     * @param tourBO       前台参数
     */
    public void setConfig(List<TourConfigBO> configBOList, TourBO tourBO) {
        //设置配置类型
        List<String> typeList = new ArrayList<String>();
        typeList.add("include");
        typeList.add("exclude");
        typeList.add("important");
        typeList.add("triphint");
        typeList.add("describe");
        typeList.add("term");
        for (int i = 0; i < typeList.size(); i++) {
            TourConfigBO tourConfigBO = new TourConfigBO();
            tourConfigBO.setTourId(tourBO.getId());
            tourConfigBO.setType(typeList.get(i));
            tourConfigBO.setName(typeList.get(i));
            configBOList.add(tourConfigBO);
        }
        for (TourConfigBO tourConfigBO : configBOList) {
            int i = 0;
            if (typeList.get(i++).equals(tourConfigBO.getType())) {
                tourConfigBO.setContentEn(tourBO.getIncludeEn());
                tourConfigBO.setContentFr(tourBO.getIncludeFr());
                continue;
            }
            if (typeList.get(i++).equals(tourConfigBO.getType())) {
                tourConfigBO.setContentEn(tourBO.getExcludeEn());
                tourConfigBO.setContentFr(tourBO.getExcludeFr());
                continue;
            }
            if (typeList.get(i++).equals(tourConfigBO.getType())) {
                tourConfigBO.setContentEn(tourBO.getImportantEn());
                tourConfigBO.setContentFr(tourBO.getImportantFr());
                continue;
            }
            if (typeList.get(i++).equals(tourConfigBO.getType())) {
                tourConfigBO.setContentEn(tourBO.getTriphintEn());
                tourConfigBO.setContentFr(tourBO.getTriphintFr());
                continue;
            }
            if (typeList.get(i++).equals(tourConfigBO.getType())) {
                tourConfigBO.setContentEn(tourBO.getDescEn());
                tourConfigBO.setContentFr(tourBO.getDescFr());
                continue;
            }
            if (typeList.get(i).equals(tourConfigBO.getType())) {
                tourConfigBO.setContentEn(tourBO.getTermEn());
                tourConfigBO.setContentFr(tourBO.getTermFr());
            }
        }
    }

    /**
     * 设置目的地信息
     *
     * @param tourBO
     */
    public void setDestiantion(List<TourDestinationBO> destinationBOList, TourBO tourBO) {
        List<Integer> dests = tourBO.getDestination();
        if (dests != null && dests.size() > 0) {
            for (Integer dest : dests) {
                TourDestinationBO tourDestinationBO = new TourDestinationBO();
                tourDestinationBO.setDestId(dest);
                tourDestinationBO.setTourId(tourBO.getId());
                destinationBOList.add(tourDestinationBO);
            }
        }
    }

    /**
     * 设置途径城市信息
     *
     * @param tourBO
     */
    public void setWayCity(List<TourWayCityBO> tourWayCityBOs, TourBO tourBO) {
        List<Integer> citys = tourBO.getWayCity();
        if (citys != null && citys.size() > 0) {
            for (Integer city : citys) {
                TourWayCityBO tourWayCityBO = new TourWayCityBO();
                tourWayCityBO.setTourId(tourBO.getId());
                tourWayCityBO.setCityId(city);
                tourWayCityBOs.add(tourWayCityBO);
            }
        }
    }

    /**
     * 保存线路图片
     *
     * @param tourVO
     */
    public void saveImage(TourVO tourVO) {
        TourBO tourBO = new TourBO();
        BeanUtils.copyProperties(tourVO, tourBO);
        //删除原数据库图片信息
        tourMapper.deleteImageById(tourBO.getId());
        //修改图片
        setImage(tourBO.getImageData(), tourBO.getCover(), tourBO.getId(), true);
    }

    /**
     * 处理图片
     *
     * @param list
     * @param cover
     * @param id
     * @param covers
     */
    public void setImage(List<String> list, List<Integer> cover, Integer id, Boolean covers) {
        List<TourImageBO> imageBOList = new ArrayList<TourImageBO>();
        if (list != null) {
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                TourImageBO tourImageBO = new TourImageBO();
                tourImageBO.setTourId(id);
                tourImageBO.setImageUrl(list.get(i));
                tourImageBO.setOrder(cover.get(i));
                tourImageBO.setThumbnail(0);
                if (cover.get(i) == 1) {
                    tourImageBO.setThumbnail(1);
                    flag = false;
                }
                imageBOList.add(tourImageBO);
            }
            //如果没有设置封面，默认第一个为封面
            if (flag && covers) {
                imageBOList.get(0).setThumbnail(1);
            }
            tourMapper.insertImage(imageBOList);
        }
    }

    /**
     * 根据id获取线路管理信息
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<TourBO> getBaseInfoById(Integer id) {
        //设置配置类型
        List<String> typeList = new ArrayList<String>();
        typeList.add("include");
        typeList.add("exclude");
        typeList.add("important");
        typeList.add("triphint");
        typeList.add("term");
        typeList.add("describe");
        Page<TourBO> page = new Page<TourBO>();
        List<Tour> list = tourMapper.selectBaseInfoById(id);
        List<TourBO> tourBOList = new ArrayList<TourBO>();
        TourBO tourBO1 = new TourBO();
        Boolean flag = true;
        //获取类型值并设置对应项
        for (Tour tour : list) {
            if (flag) {
                BeanUtils.copyProperties(tour, tourBO1);
                flag = false;
            }
            int i = 0;
            if (typeList.get(i++).equals(tour.getType())) {
                tourBO1.setIncludeEn(tour.getContentEn());
                tourBO1.setIncludeFr(tour.getContentFr());
                continue;
            }
            if (typeList.get(i++).equals(tour.getType())) {
                tourBO1.setExcludeEn(tour.getContentEn());
                tourBO1.setExcludeFr(tour.getContentFr());
                continue;
            }
            if (typeList.get(i++).equals(tour.getType())) {
                tourBO1.setImportantEn(tour.getContentEn());
                tourBO1.setImportantFr(tour.getContentFr());
                continue;
            }
            if (typeList.get(i++).equals(tour.getType())) {
                tourBO1.setTriphintEn(tour.getContentEn());
                tourBO1.setTriphintFr(tour.getContentFr());
                continue;
            }
            if (typeList.get(i++).equals(tour.getType())) {
                tourBO1.setTermEn(tour.getContentEn());
                tourBO1.setTermFr(tour.getContentFr());
                continue;
            }
            if (typeList.get(i).equals(tour.getType())) {
                tourBO1.setDescEn(tour.getContentEn());
                tourBO1.setDescFr(tour.getContentFr());
            }
        }
        tourBO1.setDestination(tourMapper.getTourDestination(id));
        tourBO1.setWayCity(tourMapper.getTourWayCity(id));
        tourBOList.add(tourBO1);
        page.setData(tourBOList);
        return page;
    }

    /**
     * 根据id获取线路选项信息
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<TourOption> getTourOption(Integer id, String language) {
        int count = tourMapper.selectTourOptionByIdCount(id);
        List<TourOption> tourOptionList = new ArrayList<TourOption>();
        TourOption option = null;
        if (count > 0) {
            List<TourOption> tourOptionLists = tourMapper.selectTourOptionById(id, language);
            int len = tourOptionLists.size();
            int flagId = tourOptionLists.get(0).getOptionId();
            Boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (flagId == tourOptionLists.get(i).getOptionId()) {
                    if (flag) {
                        option = new TourOption();
                        option.setOptionName(tourOptionLists.get(i).getOptionName());
                        option.setOptionId(tourOptionLists.get(i).getOptionId());
                        option.setOptionValueNameList(new ArrayList<String>());
                        option.setOptionValuePriceList(new ArrayList<Double>());
                        option.setIdList(new ArrayList<Integer>());
                        option.setDefaults(new ArrayList<Integer>());
                        flag = false;
                    }
                    option.getOptionValueNameList().add(tourOptionLists.get(i).getOptionValueName());
                    option.getOptionValuePriceList().add(tourOptionLists.get(i).getPrice());
                    option.getIdList().add(tourOptionLists.get(i).getId());
                    option.getDefaults().add(tourOptionLists.get(i).getToleration());
                } else {
                    tourOptionList.add(option);
                    flagId = tourOptionLists.get(i--).getOptionId();
                    flag = true;
                }
            }
            tourOptionList.add(option);
        }
        Page<TourOption> page = new Page<TourOption>();
        page.setData(tourOptionList);
        page.setTotal(count);
        return page;
    }

    /**
     * 更新旅游线路信息
     *
     * @param tourVO
     * @param userBO
     */
    public void editBaseInfo(TourVO tourVO, UserBO userBO) {
        TourBO tourBO = new TourBO();
        BeanUtils.copyProperties(tourVO, tourBO);
        tourBO.setOperateTime(new Date());
        tourBO.setOperator(userBO.getName());
        tourBO.setCategory(0);
        tourBO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        tourMapper.updateBaseInfo(tourBO);
        List<TourConfigBO> tourConfigBOList = new ArrayList<TourConfigBO>();
        setConfig(tourConfigBOList, tourBO);
        for (TourConfigBO tourConfigBO : tourConfigBOList) {
            tourMapper.updateTourConfig(tourConfigBO);
        }

        //修改目的地
        tourMapper.deleteTourDestination(tourBO.getId());
        List<TourDestinationBO> destinationBOList = new ArrayList<TourDestinationBO>();
        setDestiantion(destinationBOList, tourBO);
        if (destinationBOList.size() > 0) {
            tourMapper.insertDestination(destinationBOList);
        }
        //修改途经城市
        tourMapper.deleteTourWayCity(tourBO.getId());
        List<TourWayCityBO> wayCityBOList = new ArrayList<TourWayCityBO>();
        setWayCity(wayCityBOList, tourBO);
        if (wayCityBOList.size() > 0) {
            tourMapper.insertWayCity(wayCityBOList);
        }
    }


    /**
     * 根据id删除行程详情信息
     *
     * @param id
     */
    public void delDetail(String[] id) {
        List<String> list = CollectionUtils.arrayToList(id);
        tourMapper.delDetail(list);
    }

    /**
     * 保存行程详情
     *
     * @param tourDetailVO
     */
    public void saveDetail(TourDetailVO tourDetailVO) {
        TourDetailBO tourDetailBO = new TourDetailBO();
        BeanUtils.copyProperties(tourDetailVO, tourDetailBO);
        tourMapper.addDetail(tourDetailBO);
        setImage(tourDetailBO.getImageData(), tourDetailBO.getCover(), tourDetailBO.getTourId(), false);
    }

    /**
     * 根据id更新已有详情信息
     *
     * @param tourDetailVO
     */
    public void editDetail(TourDetailVO tourDetailVO) {
        TourDetailBO tourDetailBO = new TourDetailBO();
        BeanUtils.copyProperties(tourDetailVO, tourDetailBO);
        tourMapper.updateDetail(tourDetailBO);
        setImage(tourDetailBO.getImageData(), tourDetailBO.getCover(), tourDetailBO.getTourId(), false);
    }

    /**
     * 获取线路代码
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Boolean getTourCode(String code) {
        Boolean flag = false;
        int count = tourMapper.getTourCode(code);
        if (count > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 保存图片
     *
     * @param request
     * @param userBO
     */
    public List<String> uploadImage(HttpServletRequest request, UserBO userBO, String serverPath) throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {
        List<String> imageUrls = new ArrayList<String>();
        List<FileItem> fileItems = FileUploadUtil.getFileItem(request);
        String savePath = SAVEPATH + userBO.getUsername();
        List<FileItem> list = new ArrayList<FileItem>();
        String text = "Beautiful China";
        for (FileItem fileItem : fileItems) {
            if (getFileExtName(fileItem.getName()) != null) {
                list.add(fileItem);
                continue;
            }
            if (!"".equalsIgnoreCase(fileItem.getString("UTF-8"))) {
                text = fileItem.getString("UTF-8");
            }
        }
        for (FileItem fileItem : list) {
            InputStream in = null;
            FileOutputStream out = null;
            try {
                in = fileItem.getInputStream();
                String fileName = System.currentTimeMillis() + getFileExtName(fileItem.getName());
                String realSavePath = savePath + "/" + fileName;
                imageUrls.add(realSavePath);
                File file = new File(serverPath + savePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                out = new FileOutputStream(serverPath + realSavePath);
                byte buffer[] = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
                fileItem.delete();
                String path = serverPath + realSavePath;
                String tempPath = serverPath + savePath + "/" + "temp" + fileName;
                File f = new File(path);
                BufferedImage bi = ImageIO.read(f);
                int size = 1200;
                int diff = bi.getWidth() - size;
                if (diff <= 0) {
                    ImageUtil.scaleByRatio(path, tempPath, (size * 1.0) / bi.getWidth(), true);
                } else {
                    ImageUtil.scaleByRatio(path, tempPath, bi.getWidth() / (size * 1.0), false);
                }
                f = new File(tempPath);
                path = f.getAbsolutePath();
                String textPath = serverPath + savePath + "/" + "press" + fileName;
                ImageUtil.pressText(text, path, textPath, "", Font.BOLD, Color.WHITE, 100, 0, 50, 0.4f, 30);
                ImageUtil.scaleBySize(textPath, serverPath + savePath + "/" + "large_" + fileName, 667, 1000, false);
                ImageUtil.scaleBySize(textPath, serverPath + savePath + "/" + "medium_" + fileName, 533, 800, false);
                ImageUtil.scaleBySize(textPath, serverPath + savePath + "/" + "small_" + fileName, 78, 117, false);
                File textFile = new File(textPath);
                f.delete();
                textFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return imageUrls;
    }

    /**
     * 删除用户无用文件
     *
     * @param request
     * @param userBO
     */
    public void delTemp(HttpServletRequest request, UserBO userBO, String serverPath) {
        List<Map<String, String>> urlList = tourMapper.getUserImage(userBO.getDeptInfoBO().getDeptCode());
        if (urlList != null) {
//            String serverPath = request.getServletContext().getRealPath("");
            String savePath = SAVEPATH + userBO.getUsername();
            File root = new File(serverPath + savePath);
            File[] files = root.listFiles();
            boolean flag;
            String url;
            String imageUrl;
            if (files != null) {
                for (File file : files) {
                    int fileIndex = file.getName().indexOf("_");
                    String fileName = file.getName();
                    if (fileIndex != -1) {
                        fileName = fileName.substring(fileIndex + 1);
                    }
                    flag = true;
                    for (Map<String, String> map : urlList) {
                        url = map.get("url");
                        imageUrl = url.substring(url.lastIndexOf("/") + 1);
                        if (fileName.equals(imageUrl)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        file.delete();
                    }
                }
            }
        }
    }

    /**
     * 获取所有选项
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getAllOption(String optionId, String language) {
        if (optionId != null) {
            String[] optionIds = optionId.split(",");
            List<Integer> optionIdList = CollectionUtils.arrayToList(optionIds);
            List<Map<String, String>> list = tourMapper.selectAllOption(language, optionIdList);
            return list;
        }
        return null;
    }

    /**
     * 根据选项id获取选项值
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getOptionValueById(Integer id, Integer tourId, String language) {
        List<Map<String, String>> list = tourMapper.selectOptionValueById(id, language, tourId);
        return list;
    }
    /**
     * 根据选项orderNo获取选项值
     *
     * @param orderNo,tourId,language
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getOptionValueByOrderNo(String orderNo, Integer tourId, String language) {
        List<Map<String, String>> list = tourMapper.selectOptionValueByOrderNo(orderNo, language, tourId);
        return list;
    }


    /**
     * 根据选项id获取已用选项值
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getExistOptionValueById(Integer tourId, Integer id, String language) {
        List<Map<String, String>> list = tourMapper.selectExistOptionValueById(id, language, tourId);
        return list;
    }

    /**
     * 根据选项id获取已用选项值
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getExistOptionValueByOrderNo(Integer tourId, Integer id,String orderNo,String language) {
        List<Map<String, String>> list = tourMapper.getExistOptionValueByOrderNo(id, language, tourId,orderNo);
        return list;
    }

    /**
     * 保存选项值
     *
     * @param tourOptionVO
     * @return
     */
    public void saveOption(TourOptionVO tourOptionVO) {
        List<Integer> idList = tourOptionVO.getOptionValueIdList();
        List<Double> priceList = tourOptionVO.getOptionValuePriceList();
        if (idList != null) {
            Integer tourId = tourOptionVO.getTourId();
            List<Integer> defaults = tourOptionVO.getDefaults();
            List<Map> list = new ArrayList<Map>();
            Boolean flag = true;
            for (int i = 0, len = idList.size(); i < len; i++) {
                Map map = new HashMap();
                map.put("tourId", tourId);
                map.put("price", priceList.get(i));
                map.put("valueId", idList.get(i));
                if (defaults != null && defaults.size() != 0) {
                    for (int j = 0, length = defaults.size(); j < length; j++) {
                        if (idList.get(i).equals(defaults.get(j))) {
                            map.put("defaults", 1);
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    map.put("defaults", 0);
                }
                flag = true;
                list.add(map);
            }
            if (tourOptionVO.getStatus() != null && "edit".equalsIgnoreCase(tourOptionVO.getStatus())) {
                tourMapper.deleteTourOptionValue(tourOptionVO.getIdList());
            }
            tourMapper.insertTourOptionValue(list);
        }

    }

    /**
     * 删除选项值
     *
     * @param ids
     * @return
     */
    public void deleteOption(String[] ids) {
        List<Integer> list = CollectionUtils.arrayToList(ids);
        tourMapper.deleteTourOptionValue(list);
    }
}
