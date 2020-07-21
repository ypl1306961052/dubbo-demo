package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-13:54-2020
*/


import cn.hutool.core.util.ObjectUtil;
import com.sun.org.apache.regexp.internal.RE;
import com.ypl.test.mysql.util.MapUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: DefaultHandleParams
 * @Package com.ypl.test.mysql
 * @Description: (sql 参数转换)
 * @date 2020/7/21 13:54
 */


public class DefaultSqlConvert implements SqlConvert {
    private Pattern p = Pattern.compile("#\\{\\w*}");
    private final static String sqlPlace = "?";

    public SqlConvertResult convertMap(String sql, Map<String, Object> params) {
        List<Params> paramsList = new ArrayList<>();
        Matcher matcher = p.matcher(sql);
        int count = 1;
        while (matcher.find()) {
            String placeholder = matcher.group();
            sql = sql.replace(placeholder, sqlPlace);
            String key = placeholder.substring(2, placeholder.length() - 1);
            Object value = params.get(key);
            Params p = new Params();
            p.setIndex(count);
            p.setSqlPlaceholder(key);
            p.setValue(value);

            count++;
            paramsList.add(p);
        }

        SqlConvertResult sqlConvertResult = new SqlConvertResult();
        sqlConvertResult.setParams(paramsList);
        sqlConvertResult.setSql(sql);
        return sqlConvertResult;
    }

    public SqlConvertResult convertList(String sql, List<Object> params) {
        List<Params> paramsList = new ArrayList<>();
        Matcher matcher = p.matcher(sql);
        int count = 1;
        int index = 0;
        while (matcher.find()) {
            String placeholder = matcher.group();
            sql = sql.replace(placeholder, sqlPlace);
            String key = placeholder.substring(2, placeholder.length() - 1);
            Object value = params.get(index);
            Params p = new Params();
            p.setIndex(count);
            p.setSqlPlaceholder(key);
            p.setValue(value);

            count++;
            index++;
            paramsList.add(p);
        }
        SqlConvertResult sqlConvertResult = new SqlConvertResult();
        sqlConvertResult.setSql(sql);
        sqlConvertResult.setParams(paramsList);
        return sqlConvertResult;
    }

    public SqlConvertResult convertObject(String sql, Object params) {


        return convertMap(sql,MapUtil.objectConvertMap(params));
    }

    @Override
    public SqlConvertResult convertSql(String sql, Object params) {
        if (params instanceof Map) {
            Map<String, Object> p = (Map<String, Object>) params;
            return convertMap(sql, p);
        } else if (params instanceof List) {
            List<Object> p = (List<Object>) params;
            return convertList(sql, p);
        }
        return convertObject(sql, params);
    }
}