package com.github.hhjin015;

import com.github.hhjin015.controller.ByeController;
import com.github.hhjin015.controller.HelloController;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MySpringApp {
    /**
     * servlet container 와 spring container 의 차이점
     */
    static GenericApplicationContext applicationContext = new GenericApplicationContext();

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void main(String[] args) {

        /**
         * spring container 에 우리가 만든 객체가 bean 으로 등록되었다!
         */
        applicationContext.registerBean(HelloController.class);
        applicationContext.registerBean(ByeController.class);

        applicationContext.refresh();

        MyServletContext container = new MyServletContext();

        WebServer webServer = new TomcatServletWebServerFactory().getWebServer(container);

        webServer.start();
    }
}
