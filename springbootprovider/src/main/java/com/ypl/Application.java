package com.ypl;
/*
作者：yangp
创建时间：2020/7/1-9:23-2020
*/


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: Application
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 9:23
 */
@EnableDubbo
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
