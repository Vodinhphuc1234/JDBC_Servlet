package com.example.demo1.impl;

import com.example.demo1.Mapper.impl.PostMapper;
import com.example.demo1.dao.IPostDAO;
import com.example.demo1.model.postModel;
import com.example.demo1.paging.Pagable;


import java.sql.*;
import java.util.List;

public class postDAO extends AbstractDAO<postModel> implements IPostDAO {

    @Override
    public List<postModel> findAll(Pagable pagable) {
        StringBuilder sql = new StringBuilder("select * from posts ");

        if (pagable.getPage() != null && pagable.getPerPage() != null)
            sql.append("limit ").append(pagable.getOffset()).append(",").append(pagable.getLimit());
        if (pagable.getSortBy() != null && pagable.getSortName() != null)
            sql.append(" order by ").append(pagable.getSortName()).append(" ").append(pagable.getSortBy());
        return query(sql.toString(), new PostMapper());
    }

    @Override
    public Long save(postModel post) {
        post.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        post.setCreatedBy("");

        String sql = "insert into posts(shortdescription, thumbnail, content, title, views, userid, createddate, createdby) values(?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, post.getShortDescription(), post.getThumbnail(), post.getContent(), post.getTitle(), 0L,
                post.getUserid(), post.getCreatedDate(), post.getCreatedBy());
    }

    @Override
    public postModel findOne(Long id) {
        String sql = "select * from posts where id = ?";
        List<postModel> postModels = query(sql, new PostMapper(), id);
        return postModels.isEmpty() ? null : postModels.get(0);
    }

    @Override
    public void saveUpdate(postModel post) {
        postModel oldPost = findOne(post.getId());

        post.setCreatedDate(oldPost.getCreatedDate());
        post.setCreatedBy(oldPost.getCreatedBy());
        post.setViews(oldPost.getViews());
        post.setUserid(oldPost.getUserid());
        post.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        post.setModifiedBy("");

        String sql = "update posts" +
                " set shortdescription=?, content=?, title=?, userid=?, " +
                "thumbnail=?, views=?, modifiedby=?, modifieddate=? where id=?";
        update(sql, post.getShortDescription(), post.getContent(), post.getTitle(),
                post.getUserid(), post.getThumbnail(), post.getViews(), post.getModifiedBy(), post.getModifiedDate(),
                post.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "delete from posts where id=?";

        update(sql, id);
    }

    @Override
    public int count() {
        String sql = "select count(*) from posts";
        return getCount(sql);
    }

    @Override
    public List<postModel> findAllByUser(Pagable pagable, String userName) {
        StringBuilder sql = new StringBuilder("select * from posts where createdby=?");
        if (pagable.getPage() != null && pagable.getPerPage() != null)
            sql.append(" limit ").append(pagable.getOffset()).append(" , ").append(pagable.getLimit());
        if (pagable.getSortBy() != null && pagable.getSortName() != null)
            sql.append(" order by ").append(pagable.getSortName()).append(" ").append(pagable.getSortBy());
        return query(sql.toString(), new PostMapper(), userName);
    }

    @Override
    public Object countOf(String userName) {
        String sql = "select count(*) from posts where createdBy=?";
        return getCountOf(sql, userName);
    }

    private Object getCountOf(String sql, String userName) {
        PreparedStatement preparedStatement = null;
        Connection connection=null;
        ResultSet resultSet=null;
        int result=0;
        try {
            connection=getConnection();
            preparedStatement=connection.prepareStatement(sql);
            setParameters(preparedStatement, new String[]{userName});
            resultSet=preparedStatement.executeQuery();

            if(resultSet.next()) {
                result=resultSet.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                if (connection!=null)
                    connection.close();
                if (preparedStatement!=null)
                    preparedStatement.close();
                if (resultSet!=null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
