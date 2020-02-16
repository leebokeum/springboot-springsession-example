package com.example.session.springsession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SpringSessionCoreController {

    @Resource
    private UserInfo userInfo;

    @PostMapping("signin")
    public String signin() {
        userInfo.setUserId(123L);
        userInfo.setUserNm("leebokeum");
        return "로그인성공";
    }

    @GetMapping("session")
    public String get() {
        return userInfo.toString();
    }
}
