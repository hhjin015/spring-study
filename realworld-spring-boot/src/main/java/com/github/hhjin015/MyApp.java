package com.github.hhjin015;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {

    /**
     * CQS
     *
     * command, query separation
     *
     * command
     *  - dp 의 command pattern 아님
     *  - side effect 를 유발 (부수효과: 상태를 변경한다. -> 속성변경한다)
     *  - void (반환하지 않아)
     *
     * query
     *  - db query 아님.
     *  - side effect 를 유발하지 않는다 (상태를 변경하지 않는다)
     *  - 뭔가를 반환해
     */

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
