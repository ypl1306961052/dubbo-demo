package com.ypl.test.explan;
/*
作者：yangp
创建时间：2020/7/17-17:02-2020
*/


import com.alibaba.druid.pool.DruidDataSource;
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
import java.sql.Connection;
import java.sql.SQLException;
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


public class YplSqlSession implements SqlSession {
    private Executor executor;
    private  Configuration configuration;

    public YplSqlSession() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://10.241.21.13:3306/riskmission?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false&allowMultiQueries=true&serverTimezone=GMT%2B8");
        druidDataSource.setName("risk");
        druidDataSource.setPassword("risk2020");
        Environment environment=new Environment("dev", new JdbcTransactionFactory(),druidDataSource);
        configuration=new Configuration(environment);
    }

    public YplSqlSession(Executor executor) {
        this.executor = executor;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String s) {
        SqlSource sqlSource=new YplSqlSource(s,null);

        MappedStatement.Builder builder1 = new MappedStatement.Builder(configuration, null, sqlSource, null);
        MappedStatement statement = builder1.build();
        try {
            executor.query(statement, null, null, resultContext -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public <T> T selectOne(String s, Object o) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String s) {
        return null;
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
