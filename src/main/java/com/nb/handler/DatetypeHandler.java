package com.nb.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nb.domain.User;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class DatetypeHandler extends BaseTypeHandler<Date> {
    //将java类型 转换成 数据库类型

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time= date.getTime();
        preparedStatement.setLong(i,time);

    }

    /*
    * 将数据库中的类型转换成java类型
    * resultSet:查询出的结果集
    * s:要转换的字段名称
    * */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        long along=resultSet.getLong(s);
        Date date = new Date(along);
        return date;
    }
    //将数据库中的类型转换成java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long along=resultSet.getLong(i);
        Date date = new Date(along);
        return date;
    }
    //将数据库中的类型转换成java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long along=callableStatement.getLong(i);
        Date date = new Date(along);
        return date;
    }
}
