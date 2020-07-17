package com.ypl.test.explan;
/*
作者：yangp
创建时间：2020/7/17-17:09-2020
*/


import org.apache.commons.collections.set.ListOrderedSet;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;

import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: YplSqlSource
 * @Package com.ypl.test.explan
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/17 17:09
 */


public class YplSqlSource implements SqlSource {
    private String sql;
    private List<ParameterMapping> parameterMappings;

    public YplSqlSource(String sql,List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings=parameterMappings;
    }

    @Override
    public BoundSql getBoundSql(Object arg) {
        return new BoundSql(null,sql,parameterMappings,arg );
    }
}
