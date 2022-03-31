package com.example.demo1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public  HttpUtil (String v){
        value=v;
    }

    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static HttpUtil of (BufferedReader br){
        try {
            StringBuilder st=new StringBuilder();
            String line;
            while((line=br.readLine())!=null){
                st.append(line);
            }

            return new HttpUtil(st.toString());
        }catch (IOException e){
            return null;
        }
    }
}
