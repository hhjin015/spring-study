package com.github.hhjin015;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller(value = "xx") // 이것도 역시 Component 다. 안에 들어가면 볼 수 있어요
public class HelloController {

    private final HelloService service;

    @Autowired
    public HelloController(HelloService service) {
        this.service = service;
    }

    public String hello() {

        return service.hello() + " hyejin";
    }
}
