package com.github.hhjin015.servlet;

import com.github.hhjin015.controller.ByeController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ByeServlet extends HttpServlet {

    private final ByeController controller = new ByeController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[!!] byeServlet Called");
        String name = req.getQueryString().split("=")[1];
        resp.getWriter().println(controller.bye(name));
    }
}
