package com.example.demo1.service.impl;

import com.example.demo1.dao.IUserDAO;
import com.example.demo1.model.userModel;
import com.example.demo1.service.IUserService;

import javax.inject.Inject;

public class userService implements IUserService {
    @Inject
    IUserDAO userDAO;
    @Override
    public userModel findUser(String userName, String password) {
        return userDAO.findUser(userName, password);
    }

    @Override
    public userModel findUserByUserName(String userName) {
        return userDAO.findUserByUserName(userName);
    }

    @Override
    public void saveUser(userModel userModel) {
        userDAO.saveUser(userModel);
    }
}
