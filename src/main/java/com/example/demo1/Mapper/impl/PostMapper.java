package com.example.demo1.Mapper.impl;

import com.example.demo1.Mapper.RowMapper;
import com.example.demo1.model.postModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<postModel> {
    @Override
    public postModel map(ResultSet resultSet) {
        postModel post=new postModel();
        try {
            post.setId(resultSet.getLong("id"));
            post.setContent(resultSet.getString("content"));
            post.setShortDescription(resultSet.getString("shortdescription"));
            post.setThumbnail(resultSet.getString("thumbnail"));
            post.setTitle(resultSet.getString("title"));
            post.setUserid(resultSet.getLong("userid"));
            post.setViews(resultSet.getLong("views"));
            post.setCreatedBy(resultSet.getString("createdby"));
            post.setCreatedDate(resultSet.getTimestamp("createddate"));
            post.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            post.setModifiedBy(resultSet.getString("modifiedby"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  post;
    }
}
