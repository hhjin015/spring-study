package com.github.hhjin015;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    // 여기서 myApp 에 있는, ApplicationContext 에서 bean 을 꺼내와서, 사용하고싶다 => autowiring
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HelloController controller = MyApp.applicationContext.getBean("helloController", HelloController.class);

        resp.getWriter().println(controller.hello() + " it works!!");
    }
}
