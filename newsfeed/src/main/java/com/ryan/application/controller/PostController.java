package com.ryan.application.controller;

import com.ryan.application.dto.PostCreateDto;
import com.ryan.application.dto.PostDetailDto;
import com.ryan.application.dto.PostDto;
import com.ryan.domain.PostService;
import com.ryan.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseDto<List<PostDto>> posts() {
        return ResponseDto.ok(postService.getPosts());
    }

    @GetMapping("/{postId}")
    public ResponseDto<PostDto> getPost(@PathVariable Long postId) {
        return ResponseDto.ok(postService.getPost(postId));
    }

    @GetMapping("/{postId}/detail")
    public ResponseDto<PostDetailDto> getPostDetail(@PathVariable Long postId) {
        return ResponseDto.ok(postService.getPostDetail(postId));
    }

    @PostMapping
    public ResponseDto<Long> createPost(@RequestBody PostCreateDto dto) {
        return ResponseDto.ok(postService.createPost(dto));
    }
}
