package com.ypl.test.explan;
/*
作者：yangp
创建时间：2020/7/17-17:02-2020
*/


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: YplSqlSeesion
 * @Package com.ypl.test.explan
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/17 17:02
 */


public class YplSqlSession implements SqlSession, Closeable {

    private Executor executor = null;
    private Configuration configuration;

    public YplSqlSession() {

    }

    public YplSqlSession(Executor executor) {
        this.executor = executor;
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false&allowMultiQueries=true&serverTimezone=GMT%2B8");
//        druidDataSource.setName("root");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("ypl123456YPL");
        Environment environment = new Environment("dev", new JdbcTransactionFactory(), druidDataSource);
        configuration = new Configuration(environment);
    }

    public Executor getExecutor() {
        return executor;
    }


    @Override
    public <T> T selectOne(String s) {
        return null;
    }

    @Override
    public <T> T selectOne(String s, Object o) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String s) {
        SqlSource sqlSource = new YplSqlSource(s, null, this.configuration);


        MappedStatement.Builder builder1 = new MappedStatement.Builder(configuration, "org.apache.ibatis.logging.stdout.StdOutImpl", sqlSource, null);
        MappedStatement statement = builder1.build();
        try {
            return executor.query(statement, null, null, resultContext -> {
                System.out.println(resultContext.getResultObject());
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public <E> List<E> selectList(String s, Object o) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String s, Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public <K, V> Map<K, V> selectMap(String s, String s1) {
        return null;
    }

    @Override
    public <K, V> Map<K, V> selectMap(String s, Object o, String s1) {
        return null;
    }

    @Override
    public <K, V> Map<K, V> selectMap(String s, Object o, String s1, RowBounds rowBounds) {
        return null;
    }

    @Override
    public <T> Cursor<T> selectCursor(String s) {
        return null;
    }

    @Override
    public <T> Cursor<T> selectCursor(String s, Object o) {
        return null;
    }

    @Override
    public <T> Cursor<T> selectCursor(String s, Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public void select(String s, Object o, ResultHandler resultHandler) {

    }

    @Override
    public void select(String s, ResultHandler resultHandler) {

    }

    @Override
    public void select(String s, Object o, RowBounds rowBounds, ResultHandler resultHandler) {

    }

    @Override
    public int insert(String s) {
        return 0;
    }

    @Override
    public int insert(String s, Object o) {
        return 0;
    }

    @Override
    public int update(String s) {
        return 0;
    }

    @Override
    public int update(String s, Object o) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public int delete(String s, Object o) {
        return 0;
    }

    @Override
    public void commit() {

    }

    @Override
    public void commit(boolean b) {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void rollback(boolean b) {

    }

    @Override
    public List<BatchResult> flushStatements() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void clearCache() {

    }

    @Override
    public Configuration getConfiguration() {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> aClass) {
        return null;
    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
