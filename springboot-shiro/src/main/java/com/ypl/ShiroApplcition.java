package com.ypl;
/*
作者：yangp
创建时间：2020/7/31-14:26-2020
*/


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ShiroApplcition
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/31 14:26
 */
@MapperScan("com.ypl.mapper")
@SpringBootApplication
public class ShiroApplcition {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplcition.class,args);
    }
}
