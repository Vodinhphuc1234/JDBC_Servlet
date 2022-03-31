package com.example.demo1.dao;

import com.example.demo1.Mapper.RowMapper;

import java.sql.PreparedStatement;
import java.util.List;

public interface GenericDAO<T> {
    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    int getCount(String sql);

    void update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
}
