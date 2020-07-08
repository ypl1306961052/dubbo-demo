package com.ypl;
/*
作者：yangp
创建时间：2020/6/30-17:40-2020
*/


import java.io.Serializable;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: User
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/6/30 17:40
 */


public class User implements Serializable {
    private String name;
    private String password;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
