package com.example.demo1.service;

import com.example.demo1.model.postModel;
import com.example.demo1.paging.Pagable;

import java.util.List;

public interface IPostService {
    List<postModel> findAll(Pagable pagable);

    postModel save(postModel post);

    postModel saveUpdate (postModel post);
    void delete (long[] id);

    int count();

    List<postModel> findAllByUser(Pagable pagable, String userName);

    Object countOf(String userName);
}
