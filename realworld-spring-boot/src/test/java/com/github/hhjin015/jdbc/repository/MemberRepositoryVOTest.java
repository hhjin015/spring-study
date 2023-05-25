package com.github.hhjin015.jdbc.repository;

import com.github.hhjin015.domain.Member;
import com.github.hhjin015.repository.JdbcMemberRepository;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MemberRepositoryVOTest {

    JdbcMemberRepository repository = new JdbcMemberRepository();

    @Test
    void crud() throws SQLException {
        // save
        Member member = new Member(10000);
        repository.save(member);
    }
}
