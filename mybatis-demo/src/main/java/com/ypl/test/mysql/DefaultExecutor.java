package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-12:51-2020
*/


import com.mysql.cj.MysqlType;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: DefaultExecutor
 * @Package com.ypl.test.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 12:51
 */


public class DefaultExecutor implements Executor {
    private final DataSource dataSource;
    private SqlConvert sqlConvert;

    public DefaultExecutor(DataSource dataSource) {
        this.dataSource = dataSource;
        this.sqlConvert = new DefaultSqlConvert();
    }

    @Override
    public <E> List<E> query(String sql, Object params, RowBounds rowBounds, Class<E> classResult) throws SQLException {
        if (rowBounds != null) {
            sql = addSqlLimit(rowBounds, sql);
        }


        Connection connection = getConnection();
        SqlConvertResult sqlConvertResult = sqlConvert.convertSql(sql, params);
        sql = sqlConvertResult.getSql();
        List<Params> paramsList = sqlConvertResult.getParams();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (Params p : paramsList) {
            Object value = p.getValue();





        }


        //添加参数
//        preparedStatement.set


        boolean execute = preparedStatement.execute();
        if (!execute) {
            System.out.println("sql:" + sql + " 执行失败");
            throw new SQLException("sql 执行失败");
        }


        List<Map<String, Object>> data = new ArrayList<>();
        resultSet.
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

    private String addSqlLimit(RowBounds rowBounds, String sql) {
        if (rowBounds.getOffset() == 0) {
            sql = StringUtils.trim(sql) + "limit " + rowBounds.getLimit();
        } else {
            sql = StringUtils.trim(sql) + "limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
        }
        return sql;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public Connection getConnection(boolean aoutCommit) throws SQLException {
        return getConnection();
    }
}
