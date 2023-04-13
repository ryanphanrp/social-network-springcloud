package com.ryan.application.controller;

import com.ryan.application.dto.UserCreateDto;
import com.ryan.application.dto.UserDetailDto;
import com.ryan.domain.service.UserService;
import com.ryan.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseDto<List<UserDetailDto>> users() {
        return ResponseDto.ok(userService.getUsers());
    }

    @GetMapping("/{username}")
    public ResponseDto<UserDetailDto> user(@PathVariable String username) {
        return ResponseDto.ok(userService.getUser(username));
    }

    @PostMapping
    public ResponseDto<Long> createUser(@RequestBody UserCreateDto dto) {
        return ResponseDto.ok(userService.createUser(dto));
    }

    @PostMapping("/{username}/activate")
    public ResponseDto<Object> activateUser(@PathVariable String username) {
        userService.activateUserBy(username);
        return ResponseDto.ok();
    }
}
