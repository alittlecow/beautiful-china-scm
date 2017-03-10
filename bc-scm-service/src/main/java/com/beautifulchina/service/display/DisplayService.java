/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-1-15
 */
package com.beautifulchina.service.display;


import com.beautifulchina.common.Page;
import com.beautifulchina.dao.display.DisplayMapper;
import com.beautifulchina.display.bo.DisplayBO;
import com.beautifulchina.display.pojo.Display;
import com.beautifulchina.display.vo.DisplayVO;
import com.beautifulchina.indexconfig.bo.IndexConfigBO;
import com.beautifulchina.indexconfig.pojo.IndexConfig;
import com.beautifulchina.indexconfig.vo.IndexConfigVO;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.FileUploadUtil;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.beautifulchina.util.FileUploadUtil.getFileExtName;

/**
 * 首页展示项服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DisplayService {

    @Autowired
    private DisplayMapper displayMapper;
    private static final String SAVEPATH = "/upload/display/";

    /**
     * 获取出团信息列表
     *
     * @param displayVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<DisplayBO> getTourDate(DisplayVO displayVO, String language) {
        DisplayBO displayBO = new DisplayBO();
        BeanUtils.copyProperties(displayVO, displayBO);
        int count = displayMapper.selectTourDateCount(displayBO);
        List<DisplayBO> displayListBOList = new ArrayList<DisplayBO>();
        Page<DisplayBO> displayListBOPage = new Page<DisplayBO>();
        if (count > 0) {
            displayBO.setLanguage(language);
            List<Display> displayList = displayMapper.selectTourDate(displayBO);
            if (!CollectionUtils.isEmpty(displayList)) {
                for (Display display : displayList) {
                    DisplayBO displayBo = new DisplayBO();
                    BeanUtils.copyProperties(display, displayBo);
                    displayListBOList.add(displayBo);
                }
            }
        }
        displayListBOPage.setTotal(count);
        displayListBOPage.setData(displayListBOList);
        return displayListBOPage;
    }


    /**
     * 根据id获取路线图片地址
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<String> getTourImages(Integer id) {
        List<String> list = displayMapper.selectTourImages(id);
        return list;
    }

    /**
     * 保存图片
     *
     * @param request
     * @param userBO
     */
    public String saveImage(HttpServletRequest request, UserBO userBO, String serverPath) throws InstantiationException, IllegalAccessException {
        String realSavePath = "";
        List<FileItem> fileItems = FileUploadUtil.getFileItem(request);
        String savePath = SAVEPATH + userBO.getUsername();
        for (FileItem fileItem : fileItems) {
            InputStream in = null;
            FileOutputStream out = null;
            try {
                in = fileItem.getInputStream();
                String fileName = System.currentTimeMillis() + getFileExtName(fileItem.getName());
                realSavePath = savePath + "/" + fileName;
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
        return realSavePath;
    }

    /**
     * 获取页面banner配置值
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IndexConfig> getDisplayBanner() {
        List<IndexConfig> list = displayMapper.selectDisplayBanner();
        List<IndexConfig> resultList = new ArrayList<IndexConfig>();
        String[] image = new String[4];
        String[] id = new String[4];
        String[] itemId = new String[4];
        if (list.size() > 0) {
            for (IndexConfig indexConfig : list) {
                Integer index = indexConfig.getSort() - 1;
                image[index] = indexConfig.getImage();
                id[index] = indexConfig.getId().toString();
                itemId[index] = indexConfig.getItemId().toString();
            }
        }
        for (int i = 3; i >= 0; i--) {
            if (image[i] == null) {
                image[i] = "";
            }
            if (id[i] == null) {
                id[i] = "";
            }
            if (itemId[i] == null) {
                itemId[i] = "";
            }
        }
        IndexConfig indexConfig1 = new IndexConfig();
        IndexConfig indexConfig2 = new IndexConfig();
        indexConfig1.setIds(id[0] + "-" + id[1]);
        indexConfig1.setItemIds(itemId[0] + "-" + itemId[1]);
        indexConfig1.setImage(image[0] + "-" + image[1]);
        indexConfig2.setIds(id[2] + "-" + id[3]);
        indexConfig2.setItemIds(itemId[2] + "-" + itemId[3]);
        indexConfig2.setImage(image[2] + "-" + image[3]);
        resultList.add(indexConfig1);
        resultList.add(indexConfig2);
        return resultList;
    }

    /**
     * 获取页面tour配置值
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IndexConfig> getDisplayTour(String language) {
        List<IndexConfig> list = displayMapper.selectDisplayTour(language);
        int len = list.size();
        List<IndexConfig> resultList = new ArrayList<IndexConfig>();
        int i = 1;
        while (resultList.size() < 6) {
            IndexConfig indexConfig = new IndexConfig();
            indexConfig.setSort(i++);
            resultList.add(indexConfig);
        }
        if (len > 0) {
            for (IndexConfig indexConfig : list) {
                resultList.set(indexConfig.getSort() - 1, indexConfig);
            }
        }
        return resultList;
    }

    /**
     * 获取页面trip配置值
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IndexConfig> getDisplayTrip(String language) {
        List<IndexConfig> list = displayMapper.selectDisplayTrip(language);
        int len = list.size();
        List<IndexConfig> resultList = new ArrayList<IndexConfig>();
        int i = 1;
        while (resultList.size() < 3) {
            IndexConfig indexConfig = new IndexConfig();
            indexConfig.setSort(i++);
            resultList.add(indexConfig);
        }
        if (len > 0) {
            for (IndexConfig indexConfig : list) {
                resultList.set(indexConfig.getSort() - 1, indexConfig);
            }
        }
        return resultList;
    }

    /**
     * 获取页面theme配置值
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IndexConfig> getDisplayTheme(String language) {
        List<IndexConfig> list = displayMapper.selectDisplayTheme(language);
        int len = list.size();
        List<IndexConfig> resultList = new ArrayList<IndexConfig>();
        int i = 1;
        while (resultList.size() < 6) {
            IndexConfig indexConfig = new IndexConfig();
            indexConfig.setSort(i++);
            resultList.add(indexConfig);
        }
        if (len > 0) {
            for (IndexConfig indexConfig : list) {
                resultList.set(indexConfig.getSort() - 1, indexConfig);
            }
        }
        return resultList;
    }

    /**
     * 获取页面city配置值
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IndexConfig> getDisplayCity(String language) {
        List<IndexConfig> list = displayMapper.selectDisplayCity(language);
        int len = list.size();
        List<IndexConfig> resultList = new ArrayList<IndexConfig>();
        int i = 1;
        while (resultList.size() < 6) {
            IndexConfig indexConfig = new IndexConfig();
            indexConfig.setSort(i++);
            resultList.add(indexConfig);
        }
        if (len > 0) {
            for (IndexConfig indexConfig : list) {
                resultList.set(indexConfig.getSort() - 1, indexConfig);
            }
        }
        return resultList;
    }
    
    /**
     * 保存页面配置信息
     *
     * @param indexConfigVO
     */
    public Boolean saveItemData(IndexConfigVO indexConfigVO) {
        IndexConfigBO indexConfigBO = new IndexConfigBO();
        BeanUtils.copyProperties(indexConfigVO, indexConfigBO);
        if (indexConfigBO.getItemId() == null) {
            indexConfigBO.setItemId(0);
        }
        if (indexConfigBO.getItemId() != 0) {
            List<Integer> itemIdList = displayMapper.selectItemIdByType(indexConfigBO.getType(),indexConfigBO.getId());
            if (itemIdList.size() > 0 && itemIdList.contains(indexConfigBO.getItemId())) {
                return false;
            }
        }
        if (indexConfigBO.getId() != null) {
            displayMapper.updateItemData(indexConfigBO);
        } else {
            displayMapper.insertItemData(indexConfigBO);
        }
        return true;
    }

    /**
     * 删除未使用图片
     *
     * @param userBO
     */
    public void removeUnusedImages(UserBO userBO, String SERVER_PATH) {
        List<String> imageList = displayMapper.selectAllImages();
        if (imageList.size() > 0) {
            String url;
            String fileName;
            List<String> fileNameList = new ArrayList<String>();
            for (String image : imageList) {
                fileName = image.substring(image.lastIndexOf("/") + 1);
                fileNameList.add(fileName);
            }
            String savePath = SERVER_PATH + SAVEPATH + userBO.getUsername();
            File file = new File(savePath);
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File file1 : files) {
                        url = file1.getPath();
                        fileName = url.substring(url.lastIndexOf("\\") + 1);
                        if (!fileNameList.contains(fileName)) {
                            file1.delete();
                        }
                    }
                }

            }
        }
    }
}
