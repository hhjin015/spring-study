package com.github.hhjin015.service;

import com.github.hhjin015.domain.Member;
import com.github.hhjin015.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public long create(int money) throws SQLException {
        Member member = new Member(money);
        return memberRepository.save(member);
    }
}

