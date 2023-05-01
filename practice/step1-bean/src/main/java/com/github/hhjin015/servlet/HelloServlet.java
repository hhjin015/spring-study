package com.github.hhjin015.servlet;

import com.github.hhjin015.MySpringApp;
import com.github.hhjin015.controller.HelloController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * applicationContext 에서 꺼내와야해 -> singleton 이 적용되고, 의존성 주입 (DI) 가 되는거에요
         */
        ApplicationContext applicationContext = MySpringApp.getApplicationContext();

        HelloController controller  = applicationContext.getBean(HelloController.class);

        log.info("[!!] helloServlet Called");
        String name = req.getQueryString().split("=")[1];
        resp.getWriter().println(controller.hello(name));
    }
}
