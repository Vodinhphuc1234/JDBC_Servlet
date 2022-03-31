package com.example.demo1.service.impl;

import com.example.demo1.dao.IPostDAO;
import com.example.demo1.model.postModel;
import com.example.demo1.paging.Pagable;
import com.example.demo1.service.IPostService;

import javax.inject.Inject;
import java.util.List;

public class postService implements IPostService {
    @Inject
    private IPostDAO iPostDAO;
    @Override
    public List<postModel> findAll(Pagable pagable) {
        return iPostDAO.findAll(pagable);
    }

    @Override
    public postModel save(postModel post) {
        Long id=iPostDAO.save(post);
        return iPostDAO.findOne(id);
    }

    @Override
    public postModel saveUpdate(postModel post) {
        iPostDAO.saveUpdate(post);
       return iPostDAO.findOne(post.getId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id: ids)
            iPostDAO.delete(id);
    }

    @Override
    public int count() {
        return iPostDAO.count();
    }

    @Override
    public List<postModel> findAllByUser(Pagable pagable, String userName) {
        return iPostDAO.findAllByUser(pagable, userName);
    }

    @Override
    public Object countOf(String userName) {
        return iPostDAO.countOf(userName);
    }
}
