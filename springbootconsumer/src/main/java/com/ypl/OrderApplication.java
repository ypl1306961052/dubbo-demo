package com.ypl;
/*
作者：yangp
创建时间：2020/7/1-17:46-2020
*/


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: OrderApplication
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 17:46
 */
@EnableDubbo
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);

    }
}
