package com.ryan.application.controller;

import com.ryan.application.dto.FollowUserDto;
import com.ryan.application.dto.UserFollowInfoDto;
import com.ryan.domain.service.UserFollowService;
import com.ryan.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users/follow")
public class UserFollowController {

  private final UserFollowService userFollowService;

  @GetMapping("/{userId}")
  public ResponseDto<UserFollowInfoDto> getUserFollow(@PathVariable Long userId) {
    return ResponseDto.ok(userFollowService.getUserFollowDetail(userId));
  }

  @PostMapping
  public ResponseDto<Long> follow(@RequestBody FollowUserDto dto) {
    return ResponseDto.ok(userFollowService.followUser(dto));
  }
}
