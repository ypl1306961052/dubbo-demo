package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-14:50-2020
*/


import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SqlConvertResult
 * @Package com.ypl.test.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 14:50
 */


public class SqlConvertResult {
    /**
     * 参数
     */
    private List<Params> params;
    /**
     * 替换后的代码
     */
    private String sql;

    public List<Params> getParams() {
        return params;
    }

    public void setParams(List<Params> params) {
        this.params = params;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
