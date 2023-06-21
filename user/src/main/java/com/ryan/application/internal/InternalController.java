package com.ryan.application.internal;

import com.ryan.aspect.InternalEndpoint;
import com.ryan.application.dto.UserDetailDto;
import com.ryan.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/users")
public class InternalController {
    private final UserService userService;

    @Autowired
    public InternalController(UserService userService) {
        this.userService = userService;
    }

    @InternalEndpoint
    @GetMapping("/{username}")
    public UserDetailDto getUserDetail(@PathVariable String username) {
        return userService.getUser(username);
    }
}
