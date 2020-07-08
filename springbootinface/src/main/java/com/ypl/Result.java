package com.ypl;
/*
作者：yangp
创建时间：2020/7/1-9:19-2020
*/


import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.regexp.internal.RE;

import java.io.Serializable;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: Result
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 9:19
 */


public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public static Result ok() {
        return new Result(0);
    }
    public static Result fail() {
        return new Result(0);
    }
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
