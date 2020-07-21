package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-12:39-2020
*/


import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SqlSession
 * @Package com.ypl.test.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 12:39
 */


public interface SqlSession {
    public <E> List<E> selectList(String sql, Object params, RowBounds rowBounds, Class<E> resultClass) throws SQLException;

    Connection getConnection() throws SQLException;

    Connection getConnection(boolean aoutCommit) throws SQLException;

}
