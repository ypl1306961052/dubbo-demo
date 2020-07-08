package com.ypl.test.controller;


import com.ypl.test.service.IUpmsPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.security.Permission;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
@RestController
@RequestMapping("/test/upmsPermission")
public class UpmsPermissionController {
    @Autowired
    IUpmsPermissionService iUpmsPermissionService;
}

