package com.github.hhjin015.controller;

import com.github.hhjin015.domain.Member;
import com.github.hhjin015.request.CreateMemberRequest;
import com.github.hhjin015.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/member")
    public ResponseEntity<Long> create(@RequestBody CreateMemberRequest request) throws SQLException {
        long memberId = memberService.create(request.getMoney());
        return ResponseEntity.ok(memberId);
    }
}
