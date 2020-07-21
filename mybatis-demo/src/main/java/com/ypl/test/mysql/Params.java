package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-13:43-2020
*/


/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: Params
 * @Package com.ypl.test.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 13:43
 */


public class Params {
    private int index;
    /**
     * 列入 #{userId,default:90}
     */
    private String sqlPlaceholder;
    /**
     *值
     */
    private Object value;
    /**
     * 默认值
     */
    private Object defaultValue;

    public Params() {
    }

    public Params(int index, String sqlPlaceholder, Object value, Object defaultValue) {
        this.index = index;
        this.sqlPlaceholder = sqlPlaceholder;
        this.value = value;
        this.defaultValue = defaultValue;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSqlPlaceholder() {
        return sqlPlaceholder;
    }

    public void setSqlPlaceholder(String sqlPlaceholder) {
        this.sqlPlaceholder = sqlPlaceholder;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Params{");
        sb.append("index=").append(index);
        sb.append(", sqlPlaceholder='").append(sqlPlaceholder).append('\'');
        sb.append(", value=").append(value);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append('}');
        return sb.toString();
    }
}
