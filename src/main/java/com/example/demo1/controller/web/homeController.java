package com.example.demo1.controller.web;

import com.example.demo1.model.postModel;
import com.example.demo1.paging.Pagable;
import com.example.demo1.paging.pageRequest;
import com.example.demo1.service.IPostService;
import com.example.demo1.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class homeController extends HttpServlet {
    @Inject
    private IPostService iPostService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postModel model= FormUtil.toModel(req, postModel.class);

        Pagable pagable=new pageRequest(model.getPage(), model.getPerPage(), model.getSortBy(), model.getSortName(), iPostService.count());
        List<postModel> posts=iPostService.findAll(pagable);

        model.setItems(posts);
        model.setPage(pagable.getPage());
        model.setTotal(pagable.getTotal());

        req.setAttribute("model",model);

        RequestDispatcher rq= req.getRequestDispatcher("/views/web/home.jsp");

        rq.forward(req,resp);
    }
}
