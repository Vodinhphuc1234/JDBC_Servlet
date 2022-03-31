package com.example.demo1.Mapper.impl;

import com.example.demo1.Mapper.RowMapper;
import com.example.demo1.model.postModel;
import com.example.demo1.model.roleModel;
import com.example.demo1.model.userModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<userModel> {
    @Override
    public userModel map(ResultSet resultSet) {
        userModel user=new userModel();
        roleModel role=new roleModel();
        try {
            user.setId(resultSet.getLong("id"));
            user.setUserName(resultSet.getString("username"));
            user.setFullName(resultSet.getString("fullname"));
            user.setPassword(resultSet.getString("password"));
            user.setRoleId(resultSet.getLong("roleid"));
            user.setEmail(resultSet.getString("email"));

            if (resultSet.getString("code")!=null){
                role.setName(resultSet.getString("name"));
                role.setCode(resultSet.getString("code"));

                user.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
