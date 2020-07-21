package com.ypl.test.explan;
/*
作者：yangp
创建时间：2020/7/17-15:06-2020
*/


import com.mysql.cj.MysqlType;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: YplExecutor
 * @Package com.ypl.test.explan
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/17 15:06
 */


public class YplExecutor implements Executor {
    @Override
    public int update(MappedStatement mappedStatement, Object o) throws SQLException {
        return 0;
    }

    @Override
    public <E> List<E> query(MappedStatement mappedStatement, Object o, RowBounds rowBounds, ResultHandler resultHandler, CacheKey cacheKey, BoundSql boundSql) throws SQLException {
        return null;
    }

    /**
     * @param mappedStatement
     * @param params
     * @param rowBounds       分页对象
     * @param resultHandler
     * @param <E>
     * @return
     * @throws SQLException
     */
    @Override
    public <E> List<E> query(MappedStatement mappedStatement, Object params, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException {
// params :list set object

        Connection connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
        Statement statement = connection.createStatement();
        //sql
        BoundSql boundSql = mappedStatement.getSqlSource().getBoundSql(params);
        if (StringUtils.isEmpty(boundSql.getSql())) {
            throw new SQLException("sql is empty");
        }
        ResultSet resultSet = statement.executeQuery(boundSql.getSql());


        List<Map<String, Object>> data = new ArrayList<>();
//        resultSet.
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>(resultSet.getMetaData().getColumnCount());
            //拿到列表
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                int columnType = resultSet.getMetaData().getColumnType(i);
                String columnName = resultSet.getMetaData().getColumnName(i);
                //数字 int
                if (columnType == MysqlType.INT.getJdbcType()
                        || columnType == MysqlType.TINYINT.getJdbcType()
                        || columnType == MysqlType.MEDIUMINT.getJdbcType()) {
                    map.put(columnName, resultSet.getInt(i));
                    //字符
                } else if (columnType == MysqlType.VARCHAR.getJdbcType()
                        || columnType == MysqlType.CHAR.getJdbcType()
                        || columnType == MysqlType.TEXT.getJdbcType()
                        || columnType == MysqlType.TINYTEXT.getJdbcType()
                ) {
                    map.put(columnName, resultSet.getString(i));
                    //float
                } else if (columnType == MysqlType.FLOAT.getJdbcType()) {
                    map.put(columnName, resultSet.getFloat(i));
                    //long
                } else if (columnType == MysqlType.BIGINT.getJdbcType()) {
                    map.put(columnName, resultSet.getLong(i));
                    //double
                } else if (columnType == MysqlType.DOUBLE.getJdbcType()) {
                    map.put(columnName, resultSet.getDouble(i));
                    //decimal
                } else if (columnType == MysqlType.DECIMAL.getJdbcType()) {
                    map.put(columnName, resultSet.getBigDecimal(i));

                    //时间
                } else if (columnType == MysqlType.DATE.getJdbcType()

                        || columnType == MysqlType.DATETIME.getJdbcType()) {
                    map.put(columnName, resultSet.getDate(i));
                } else if (columnType == MysqlType.TIME.getJdbcType()
                        || columnType == MysqlType.YEAR.getJdbcType()) {
                    map.put(columnName, resultSet.getTime(i));
                } else if (columnType == MysqlType.TIMESTAMP.getJdbcType()) {
                    map.put(columnName, resultSet.getTimestamp(i));
                }
                //blob
                else if (columnType == MysqlType.BLOB.getJdbcType()
                        || columnType == MysqlType.MEDIUMBLOB.getJdbcType()
                        || columnType == MysqlType.LONGBLOB.getJdbcType()
                ) {
                    map.put(columnName, resultSet.getBlob(i));
                }


            }
            data.add(map);
        }
        return (List<E>) data;
    }

    public Connection getConnection(MappedStatement mappedStatement) throws SQLException {
        return mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
    }

    @Override
    public <E> Cursor<E> queryCursor(MappedStatement mappedStatement, Object o, RowBounds rowBounds) throws SQLException {
        return null;
    }

    @Override
    public List<BatchResult> flushStatements() throws SQLException {
        return null;
    }

    @Override
    public void commit(boolean b) throws SQLException {

    }

    @Override
    public void rollback(boolean b) throws SQLException {

    }

    @Override
    public CacheKey createCacheKey(MappedStatement mappedStatement, Object o, RowBounds rowBounds, BoundSql boundSql) {
        return null;
    }

    @Override
    public boolean isCached(MappedStatement mappedStatement, CacheKey cacheKey) {
        return false;
    }

    @Override
    public void clearLocalCache() {

    }

    @Override
    public void deferLoad(MappedStatement mappedStatement, MetaObject metaObject, String s, CacheKey cacheKey, Class<?> aClass) {

    }

    @Override
    public Transaction getTransaction() {
        return null;
    }

    @Override
    public void close(boolean b) {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public void setExecutorWrapper(Executor executor) {

    }
}
