package com.example.demo1.impl;

import com.example.demo1.Mapper.RowMapper;
import com.example.demo1.dao.GenericDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnection() {
        // Load the JDBC driver

        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

        try {
            Class.forName(resourceBundle.getString("driverName"));
            String serverName = resourceBundle.getString("serverName");
            String mydatabase = resourceBundle.getString("mydatabase");
            String url = "jdbc:mysql://" + serverName +  "/" + mydatabase; // a JDBC url
            String username = resourceBundle.getString("username");
            String password = resourceBundle.getString("password");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    @Override
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        PreparedStatement preparedStatement = null;
        Connection connection=null;
        ResultSet resultSet=null;
        try {
            List<T> results =new ArrayList<>();
            connection=getConnection();
            preparedStatement=connection.prepareStatement(sql);
            setParameters(preparedStatement, parameters);
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                results.add(rowMapper.map(resultSet));
            }
            return results;
        } catch (SQLException e) {
            return null;
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

    @Override
    public void update(String sql, Object... parameters) {
        PreparedStatement preparedStatement = null;
        Connection connection=null;

        try {
            connection=getConnection();
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement(sql);
            setParameters(preparedStatement,parameters);

            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection!=null)
                    connection.close();
                if (preparedStatement!=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public Long insert(String sql, Object... parameters) {
        PreparedStatement preparedStatement = null;
        Connection connection=null;
        Long id=null;
        ResultSet resultSet=null;

        try{
            connection=getConnection();
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameters(preparedStatement,parameters);

            preparedStatement.executeUpdate();

            resultSet=preparedStatement.getGeneratedKeys();

            if (resultSet.next())
                id = resultSet.getLong(1);

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
        return id;
    }

    @Override
    public int getCount (String sql){
        PreparedStatement preparedStatement = null;
        Connection connection=null;
        ResultSet resultSet=null;
        int result=0;
        try {

            connection=getConnection();
            preparedStatement=connection.prepareStatement(sql);
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

    public void setParameters(PreparedStatement preparedStatement, Object[] parameters) {
            try {
                for (int i=0; i<parameters.length; i++) {
                    preparedStatement.setObject(i + 1, parameters[i]);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
