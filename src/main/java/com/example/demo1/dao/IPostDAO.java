package com.example.demo1.dao;

import com.example.demo1.model.postModel;
import com.example.demo1.paging.Pagable;

import java.util.List;

public interface IPostDAO extends GenericDAO<postModel>{
    List<postModel> findAll(Pagable pagable);

    Long save(postModel post);

    postModel findOne(Long id);

    void saveUpdate(postModel post);

    void delete(long id);

    int count();

    List<postModel> findAllByUser(Pagable pagable, String userName);

    Object countOf(String userName);
}
