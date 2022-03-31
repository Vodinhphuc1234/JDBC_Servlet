package com.example.demo1.api;

import com.example.demo1.model.postModel;
import com.example.demo1.service.IPostService;
import com.example.demo1.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-web-post"})
public class PostAPI extends HttpServlet {

    @Inject
    private IPostService iPostService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BufferedReader br= req.getReader();
        postModel post= HttpUtil.of(br).toModel(postModel.class);
        post=iPostService.save(post);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(resp.getOutputStream(), post);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BufferedReader br= req.getReader();
        postModel upPost= HttpUtil.of(br).toModel(postModel.class);
        upPost = iPostService.saveUpdate(upPost);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(resp.getOutputStream(), upPost);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BufferedReader br= req.getReader();
        postModel delete= HttpUtil.of(br).toModel(postModel.class);
        long[] deleteIds=delete.getIds();
        iPostService.delete(deleteIds);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(resp.getOutputStream(), null);
    }
}
