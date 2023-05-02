package com.github.hhjin015;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Slf4j
public class MyApp {

    public static GenericApplicationContext applicationContext;

    public static void main(String[] args) {
        // application context 하나를 만들것이에요

        applicationContext = new GenericApplicationContext() {
            @Override
            protected void onRefresh() throws BeansException {
                // TODO before refactoring
                /*ServletContextInitializer initializer = new ServletContextInitializer() {
                    @Override
                    public void onStartup(ServletContext servletContext) throws ServletException {
                        servletContext.addServlet("helloServlet", new HelloServlet())
                                .addMapping("/hello");
                    }
                };
                WebServer webServer = new TomcatServletWebServerFactory()
                        .getWebServer(initializer);
                webServer.start();*/

                // TODO after refactoring
                WebServer webServer = new TomcatServletWebServerFactory().getWebServer(servletContext -> servletContext.addServlet("helloServlet", new HelloServlet()).addMapping("/hello"));
                webServer.start();
            }
        };


        applicationContext.registerBean("helloController", HelloController.class);

        applicationContext.refresh();
    }
}
