package com.github.hhjin015.controller;

import com.github.hhjin015.domain.Member;
import com.github.hhjin015.request.CreateMemberRequest;
import com.github.hhjin015.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/member")
    public ResponseEntity<Member> create(@RequestBody CreateMemberRequest request) throws SQLException {
        Member member = memberService.create(request.getMoney());
        return ResponseEntity.ok(member);
    }
}
