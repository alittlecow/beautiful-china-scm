/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-01-12
 */
package com.beautifulchina.bean;

import org.apache.commons.fileupload.FileItem;

import java.util.List;

/**
 * 文件上传参数封装
 */
public class FileParam<T> {
    /**
     * 表单参数
     */
    private T form;
    /**
     * 文件参数
     */
    private List<FileItem> fileItems;

    public T getForm() {
        return form;
    }

    public void setForm(T form) {
        this.form = form;
    }

    public List<FileItem> getFileItems() {
        return fileItems;
    }

    public void setFileItems(List<FileItem> fileItems) {
        this.fileItems = fileItems;
    }
}
