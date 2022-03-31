package com.example.demo1.Mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T map(ResultSet resultSet);
}
