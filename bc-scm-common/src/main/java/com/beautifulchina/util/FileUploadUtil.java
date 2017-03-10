/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-01-12
 */
package com.beautifulchina.util;

import com.beautifulchina.bean.FileParam;
import com.beautifulchina.constants.CommonEnum;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/**
 * 参数转换工具类
 */
public class FileUploadUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

    /**
     * 隐藏工具类的构造方法
     */
    protected FileUploadUtil() {
        throw new UnsupportedOperationException();
    }


    /**
     * 上传文件参数转换成Map
     *
     * @param fileItemList
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static FileParam convertFileItem(List<FileItem> fileItemList, Class<?> clazz) throws IllegalAccessException, InstantiationException {

        if (CollectionUtils.isEmpty(fileItemList)) {
            return null;
        }

        /* 初始化参数 */
        Object obj = null;
        if (clazz != null) {
            obj = clazz.newInstance();
        }
        List<FileItem> list = new ArrayList<FileItem>();
        FileParam fileParam = new FileParam();

        for (FileItem item : fileItemList) {
            //如果封装的是普通输入项的数据
            if (item.isFormField()) {
                String name = item.getFieldName();
                String value = null;
                try {
                    //解决普通输入项的数据的中文乱码问题
                    value = item.getString("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //设置入参值
                ReflectionUtils.setFieldValue(obj, name, value);
            } else {
                //如果fileitem中封装的是上传文件
                //得到上传的文件名称，
                String filename = item.getName();
                //上传的文件的变量名
                String name = item.getFieldName();
                if (filename == null || filename.trim().equals("")) {
                    continue;
                }
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                //filename = filename.substring(filename.lastIndexOf("\\") + 1);
                //得到文件需要保存的名称
                //String saveFilename = System.currentTimeMillis()+"_";
                //map.put(saveFilename, item);
                list.add(item);
            }
        }
        fileParam.setFileItems(list);
        fileParam.setForm(obj);
        return fileParam;
    }


    /**
     * 保存图片到指定文件夹
     *
     * @param serverPath
     * @param savePath
     * @param fileParam
     * @return
     */
    public static List<String> saveFile(String serverPath, String savePath, FileParam fileParam) {
        //Map<String,String> map = new HashMap<String, String>();
        List<FileItem> fileItems = fileParam.getFileItems();
        List<String> filePaths = new ArrayList<String>();
        for (FileItem fileItem : fileItems) {
            InputStream in = null;
            FileOutputStream out = null;
            try {
                //获取item中的上传文件的输入流
                in = fileItem.getInputStream();

                //得到文件的额外保存目录
                String realSavePath = savePath + "/" + System.currentTimeMillis() + getFileExtName(fileItem.getName());
                filePaths.add(serverPath+realSavePath);
                File file = new File(serverPath + savePath);

                //如果目录不存在
                if (!file.exists()) {
                    //创建目录
                    file.mkdirs();
                }
                //创建一个文件输出流
                out = new FileOutputStream(serverPath + realSavePath);

                //创建一个缓冲区
                byte buffer[] = new byte[1024];
                //判断输入流中的数据是否已经读完的标识
                int len = 0;
                //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                while ((len = in.read(buffer)) > 0) {
                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                    out.write(buffer, 0, len);
                }
                //关闭输入流
                in.close();
                //关闭输出流
                out.close();
                //删除处理文件上传时生成的临时文件
                fileItem.delete();

                //filePaths.add(realSavePath);
                ReflectionUtils.setFieldValue(fileParam.getForm(), fileItem.getFieldName(), realSavePath);
            } catch (Exception e) {
                logger.error("上传文件失败", e);
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
        return filePaths;

    }

    /**
     * 获取文件扩展名
     *
     * @param fileName
     * @return
     */
    public static String getFileExtName(String fileName) {
        if (fileName == null) {
            return null;
        }
        return fileName.substring(fileName.indexOf("."), fileName.length());
    }

    /**
     * 获取FileItem集合
     *
     * @param request 请求
     * @return FileItem集合
     */
    public static List<FileItem> getFileItem(HttpServletRequest request) {
        //上传时生成的临时文件保存目录
        String tempPath = request.getServletContext().getRealPath(CommonEnum.UPLOAD_TEMP.getValue());
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //创建保存目录
            //dirPath.mkdir();
            tmpFile.mkdirs();
        }

        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
        factory.setSizeThreshold(1024 * 100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
        //设置上传时生成的临时文件的保存目录
        factory.setRepository(tmpFile);
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        //3、判断提交上来的数据是否是上传表单的数据
        if (!ServletFileUpload.isMultipartContent(request)) {
            return null;
        }
        //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是3MB
        upload.setFileSizeMax(1024 * 1024 * 3);
        //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为50MB
        upload.setSizeMax(1024 * 1024 * 50);
        //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
        List<FileItem> list = new ArrayList<FileItem>();
        try {
            list = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return list;
    }

}
