package com.github.hhjin015.domain;

import lombok.Data;

@Data
public class Member {

    private int memberId;
    private int money;

    public Member(int money) {
        this.money = money;
    }

    public Member(int memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }
}
