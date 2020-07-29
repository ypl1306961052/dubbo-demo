package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/29-17:24-2020
*/


/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ZkLockException
 * @Package com.ypl.zk
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/29 17:24
 */


public class ZkLockException extends RuntimeException {
    public ZkLockException() {
    }

    public ZkLockException(String message) {
        super(message);
    }

    public ZkLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZkLockException(Throwable cause) {
        super(cause);
    }

    public ZkLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
