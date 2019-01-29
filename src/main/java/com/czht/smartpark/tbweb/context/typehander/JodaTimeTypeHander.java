package com.czht.smartpark.tbweb.context.typehander;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.LocalDateTime;

import java.sql.*;

public class JodaTimeTypeHander implements TypeHandler<LocalDateTime> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, LocalDateTime dateTime, JdbcType jdbcType) throws SQLException {
        if (dateTime != null) {
            preparedStatement.setTimestamp(i, new Timestamp(dateTime.toDateTime().getMillis()));
        } else {
            preparedStatement.setTimestamp(i, null);
        }
    }

    @Override
    public LocalDateTime getResult(ResultSet resultSet, String s) throws SQLException {
        return toDateTime(resultSet.getTimestamp(s));
    }

    @Override
    public LocalDateTime getResult(ResultSet resultSet, int i) throws SQLException {
        return toDateTime(resultSet.getTimestamp(i));
    }

    @Override
    public LocalDateTime getResult(CallableStatement callableStatement, int i) throws SQLException {
        return toDateTime(callableStatement.getTimestamp(i));
    }

    private static LocalDateTime toDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            LocalDateTime dateTime = new LocalDateTime(timestamp);
            return dateTime;
        } else {
            return null;
        }
    }
}
