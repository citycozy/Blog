package com.dohyun.blog.member.controller;

import com.dohyun.blog.global.response.ApiResponse;
import com.dohyun.blog.member.dto.request.MemberRequest;
import com.dohyun.blog.member.dto.response.MemberResponse;
import com.dohyun.blog.member.facade.MemberFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class MemberController {

    private final MemberFacade memberFacade;

    public MemberController(MemberFacade memberFacade) {
        this.memberFacade = memberFacade;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<MemberResponse.Signup>> signup(
            @RequestBody MemberRequest.Signup request ){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.create(memberFacade.signup(request)));
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponse<MemberResponse.GetMember>> getLogin() {
        return ResponseEntity.ok(ApiResponse.success(memberFacade.getLoginMember()));
    }
}
