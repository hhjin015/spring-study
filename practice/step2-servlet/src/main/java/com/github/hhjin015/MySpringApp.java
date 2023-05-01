package com.github.hhjin015;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

public class MySpringApp {
    public static void main(String[] args) {
        MyServletContext container = new MyServletContext();

        WebServer webServer = new TomcatServletWebServerFactory().getWebServer(container);

        webServer.start();
    }
}
