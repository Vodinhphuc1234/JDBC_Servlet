package com.example.demo1.impl;

import com.example.demo1.Mapper.impl.PostMapper;
import com.example.demo1.Mapper.impl.UserMapper;
import com.example.demo1.dao.IPostDAO;
import com.example.demo1.dao.IUserDAO;
import com.example.demo1.model.postModel;
import com.example.demo1.model.userModel;

import java.util.List;

public class userDAO extends AbstractDAO<userModel> implements IUserDAO {
    @Override
    public userModel findUser(String userName, String password) {
        String sql="SELECT * " +
                "FROM users AS u INNER JOIN roles AS r ON u.roleid=r.id " +
                "WHERE username = ? and password=? and status=1";
        List<userModel>  userModels=query(sql, new UserMapper(), userName,password);

        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public userModel findUserByUserName(String userName) {
        String sql="SELECT * " +
                "FROM users AS u INNER JOIN roles AS r ON u.roleid=r.id " +
                "WHERE username = ? and status=1";
        List<userModel>  userModels=query(sql, new UserMapper(), userName);

        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public void saveUser(userModel user) {
        String sql="insert into users(username, password, fullname, email, roleid) values(?, ?, ?, ?, ?)";
        Long  id = insert(sql, user.getUserName(), user.getPassword(),
                user.getFullName(), user.getEmail(), 1);
    }
}
