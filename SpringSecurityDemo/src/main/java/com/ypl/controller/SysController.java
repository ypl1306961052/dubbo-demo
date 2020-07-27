package com.ypl.controller;
/*
作者：yangp
创建时间：2020/7/9-9:55-2020
*/


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SysController
 * @Package com.ypl.controller
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/9 9:55
 */

@RestController
public class SysController {
    @GetMapping("/hello")
    public String hello(){
        return "欢迎来到 spring security";

    }
}
