package com.github.hhjin015.repository;

import com.github.hhjin015.domain.Member;

import java.sql.SQLException;

public interface MemberRepository {
    long save(Member member) throws SQLException;

    Member findById(int id) throws SQLException;
}
