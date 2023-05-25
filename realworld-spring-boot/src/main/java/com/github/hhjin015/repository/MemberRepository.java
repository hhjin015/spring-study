package com.github.hhjin015.repository;

import com.github.hhjin015.domain.Member;

import java.sql.SQLException;

public interface MemberRepository {
    void save(Member member) throws SQLException;
}
