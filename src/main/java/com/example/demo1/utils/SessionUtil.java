package com.example.demo1.utils;

import com.example.demo1.model.userModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static SessionUtil Session=null;

    public static SessionUtil getInstance(){
        if (Session==null)
            Session=new SessionUtil();
        return Session;
    }

    public void putValue(HttpServletRequest request, String key, Object value){
        request.getSession().setAttribute(key, value);
    }

    public Object getValue(HttpServletRequest request, String key){
        return request.getSession().getAttribute(key);
    }

    public void removeValue(HttpServletRequest request, String key){
        request.getSession().removeAttribute(key);
    }
}
