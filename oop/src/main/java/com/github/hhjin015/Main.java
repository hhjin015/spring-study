package com.github.hhjin015;

public class Main {
    /**
     * 4 특성 (캡상추다)
     *
     * 1. 캡슐화
     * 2. 상속
     * 3. 추상화
     * 4. 다형성
     */
    public static void main(String[] args) {
        User userA = new GoodUser();
        User userB = new AntiUser();
    }
}

interface User {
    String greeting(); // what
}

class GoodUser implements User {

    @Override
    public String greeting() { // how
        return "";
    }

}

class AntiUser implements User {
    @Override
    public String greeting() {
        return "fux";
    }
}



