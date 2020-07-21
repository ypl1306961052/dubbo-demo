package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-12:42-2020
*/


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: DefaultSqlSession
 * @Package com.ypl.test.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 12:42
 */


public class DefaultSqlSession implements SqlSession {

    private final Executor executor;

    public DefaultSqlSession(Executor executor) {
        this.executor = executor;
    }


    @Override
    public <E> List<E> selectList(String sql, Object params, RowBounds rowBounds, Class<E> resultClass) throws SQLException {
        if(StringUtils.isEmpty(sql)){
            throw new SQLException("sql is empty");
        }
        return this.executor.query(sql,params,rowBounds,resultClass);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return executor.getConnection();
    }

    @Override
    public Connection getConnection(boolean aoutCommit) throws SQLException {
        return executor.getConnection();
    }

}
