package com.example.demo1.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {
    public static <T> T toModel(HttpServletRequest request, Class<T> tClass){
        T object = null;
        try {
            object=tClass.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }
}
