package com.example.demo1.controller.web;

import com.example.demo1.model.userModel;
import com.example.demo1.service.IUserService;
import com.example.demo1.utils.FormUtil;
import com.example.demo1.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet (urlPatterns = {"/login", "/logout", "/signup"})
public class authController extends HttpServlet {
    @Inject
    IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        ResourceBundle resourceBundle=ResourceBundle.getBundle("message");


        if (action.equals("login")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
            if (req.getParameter("message") != null) {
                req.setAttribute("message", resourceBundle.getString(req.getParameter("message")));
                req.setAttribute("alert", req.getParameter("alert"));
            }
            rd.forward(req, resp);
        } else if (action.equals("logout")){
            SessionUtil.getInstance().removeValue(req,"USERMODEL");
            resp.sendRedirect("/home?page=1&perPage=1");
        } else if (action.equals("signup")){
            if (req.getParameter("message")!=null){
                req.setAttribute("message", resourceBundle.getString(req.getParameter("message")));
                req.setAttribute("alert", req.getParameter("alert"));
            }
             RequestDispatcher rd = req.getRequestDispatcher("/views/web/signup.jsp");
             rd.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");

        userModel user = FormUtil.toModel(req, userModel.class);



        if (action.equals("login")) {
            user=userService.findUser(user.getUserName(), user.getPassword());
            if (user == null)
                resp.sendRedirect("/login?action=login&message=invalid_account&alert=danger");
            else {
                if (user.getRole().getCode().equals("USER")) {
                    SessionUtil.getInstance().putValue(req, "USERMODEL", user);
                    resp.sendRedirect("/home?page=1&perPage=1");
                }
            }
        } else if (action.equals("signup")){
            userModel _user=userService.findUserByUserName(user.getUserName());
            if (_user!=null){
                resp.sendRedirect("/signup?action=signup&message=existing_account&alert=danger");
            }
            else {
                userService.saveUser(user);
                SessionUtil.getInstance().putValue(req,"USERMODEL", user);
                resp.sendRedirect("/home?page=1&perPage=1");
            }

        }
    }
}
