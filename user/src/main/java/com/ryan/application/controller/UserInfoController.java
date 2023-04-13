package com.ryan.application.controller;

import com.ryan.application.dto.UserInfoCreateDto;
import com.ryan.domain.entity.pojo.UserDetail;
import com.ryan.domain.service.UserInfoService;
import com.ryan.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users/info")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @PostMapping("/{username}")
    public ResponseDto<Object> createUserInfo(@PathVariable String username, @RequestBody UserInfoCreateDto dto) {
        return ResponseDto.ok(userInfoService.createUserInfo(username, dto));
    }

    @GetMapping("/{username}")
    public ResponseDto<UserDetail> getUserDetail(@PathVariable String username) {
        return ResponseDto.ok(userInfoService.getUserInfoDetail(username));
    }
}
