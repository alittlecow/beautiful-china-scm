/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.spring;

import com.beautifulchina.handle.PropertyHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Properties;

/**
 * spring参数获取
 */
public class SpringPropertyConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
            throws BeansException {
        logger.info("开始加载properties配置");
        super.processProperties(beanFactory, props);
        PropertyHandler.loadProperties(props);
        logger.info("完成加载properties配置");
    }
}
