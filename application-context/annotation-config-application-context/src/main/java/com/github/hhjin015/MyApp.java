package com.github.hhjin015;

import org.springframework.beans.BeansException;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    public static AnnotationConfigApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext() {
            @Override
            protected void onRefresh() throws BeansException {
                WebServer webServer = new TomcatServletWebServerFactory().getWebServer(servletContext -> servletContext.addServlet("helloServlet", new HelloServlet()).addMapping("/hello"));
                webServer.start();
                super.onRefresh();
            }
        };

        // applicationContext.register(MyConfig.class); TODO step 1. using @Configuration
        applicationContext.scan("com.github.hhjin015");
        // applicationContext.scan("com.github.hhjin015.jangwonik"); failed
        applicationContext.refresh();
    }
}
