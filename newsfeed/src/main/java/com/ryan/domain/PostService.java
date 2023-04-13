package com.ryan.domain;

import com.ryan.application.dto.PostCreateDto;
import com.ryan.application.dto.PostDetailDto;
import com.ryan.application.dto.PostDto;
import com.ryan.application.dto.UserDetailDto;
import com.ryan.exception.customize.NotFoundException;
import com.ryan.infrastructure.UserRestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostDao postDao;
    private final UserRestService userRestService;

    @Autowired
    public PostService(PostDao postDao, UserRestService userRestService) {
        this.postDao = postDao;
        this.userRestService = userRestService;
    }

    public PostDto getPost(Long postId) {
        Post post = postDao.findPostByPostId(postId)
            .orElseThrow(NotFoundException::new);
        return PostDto.of(post);
    }

    public Long createPost(PostCreateDto dto) {
        return postDao.save(dto.toEntity()).getPostId();
    }

    public List<PostDto> getPosts() {
        return postDao.findAll()
            .stream()
            .map(PostDto::of)
            .toList();
    }

    public PostDetailDto getPostDetail(Long postId) {
        PostDto post = getPost(postId);
        UserDetailDto userDetail = userRestService.getUser(post.user().username());
        return PostDetailDto.of(
            post,
            userDetail
        );
    }
}
