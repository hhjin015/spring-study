package com.github.hhjin015;

import com.github.hhjin015.servlet.ByeServlet;
import com.github.hhjin015.servlet.HelloServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyServletContext implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        HelloServlet helloServlet = new HelloServlet();
        ByeServlet byeServlet = new ByeServlet();

        servletContext.addServlet("helloServlet", helloServlet)
                .addMapping("/hello");

        servletContext.addServlet("byeServlet", byeServlet)
                .addMapping("/bye");
    }
}
