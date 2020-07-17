package com.ypl.test.config;
/*
作者：yangp
创建时间：2020/7/17-13:53-2020
*/


import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: PageHelperConfig
 * @Package com.ypl.test.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/17 13:53
 */

@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper=new PageHelper();
        Properties properties=new Properties();
        properties.setProperty("offsetAsPageNum","true");

        //设置为true时，使用RowBounds分页会进行count查询
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
