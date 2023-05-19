package com.github.hhjin015;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hell")
    public String a() {
        ThreadLocal<Integer> tl  = new InheritableThreadLocal<>();
        tl.set(10);
        return Thread.currentThread().getName();
    }

}
