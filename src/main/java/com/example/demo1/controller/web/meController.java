package com.example.demo1.controller.web;

import com.example.demo1.model.postModel;
import com.example.demo1.model.userModel;
import com.example.demo1.paging.Pagable;
import com.example.demo1.paging.pageRequest;
import com.example.demo1.service.IPostService;
import com.example.demo1.utils.FormUtil;
import com.example.demo1.utils.HttpUtil;
import com.example.demo1.utils.SessionUtil;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@WebServlet(urlPatterns = {"/me"})
public class meController extends HttpServlet {
    @Inject
    IPostService postService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher rd = null;
        
        postModel postModel = FormUtil.toModel(req, com.example.demo1.model.postModel.class);
        Pagable pagable = new pageRequest(postModel.getPage(), postModel.getPerPage(), null, null,postService.count());
        userModel currentUser= (userModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        List<postModel> posts = postService.findAllByUser(pagable, currentUser.getUserName());
        if (req.getParameter("page") != null){
            req.setAttribute("total", postService.countOf(currentUser.getUserName()));
            req.setAttribute("page", postModel.getPage());
            req.setAttribute("posts", posts);
            rd= req.getRequestDispatcher("/views/web/myPosts.jsp");
        } else if (action.equals("viewInformation"))
        {
            rd= req.getRequestDispatcher("/views/web/me.jsp");
        }
        rd.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postModel postModel = HttpUtil.of(req.getReader()).toModel(com.example.demo1.model.postModel.class);
        postService.delete(postModel.getIds());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("{issue:true}");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
