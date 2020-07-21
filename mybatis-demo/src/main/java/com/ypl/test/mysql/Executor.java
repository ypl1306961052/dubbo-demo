package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-12:49-2020
*/


import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: Executor
 * @Package com.ypl.test.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 12:49
 */


public interface Executor {
    <E> List<E> query(String sql, Object params, RowBounds rowBounds,Class<E> classResult) throws SQLException;
    Connection getConnection() throws SQLException;

    Connection getConnection(boolean aoutCommit) throws SQLException;
}
