package com.github.hhjin015;

import com.github.hhjin015.servlet.HelloServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyServletContext  implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        HelloServlet hs = new HelloServlet();

        servletContext.addServlet("dispatcherServlet", hs)
                .addMapping("/*");
    }
}
