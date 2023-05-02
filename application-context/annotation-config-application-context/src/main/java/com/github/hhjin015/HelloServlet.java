package com.github.hhjin015;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HelloController xx = (HelloController) MyApp.applicationContext.getBean("xx");

        resp.getWriter().println(xx.hello() + " it works!!");
    }
}
