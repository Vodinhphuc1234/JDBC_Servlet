package com.example.demo1.dao;

import com.example.demo1.model.postModel;
import com.example.demo1.model.userModel;

public interface IUserDAO extends GenericDAO<userModel>{
    userModel findUser(String userName, String password);

    userModel findUserByUserName(String userName);

    void saveUser(userModel userModel);
}
