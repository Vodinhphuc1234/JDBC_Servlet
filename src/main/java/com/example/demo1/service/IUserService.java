package com.example.demo1.service;

import com.example.demo1.model.userModel;

public interface IUserService {
    userModel findUser (String userName, String password);

    userModel findUserByUserName(String userName);

    void saveUser(userModel userModel);

}
