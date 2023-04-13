package com.ryan.infrastructure;

import com.ryan.application.dto.UserDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user",  url = "${service.feign.uri}", configuration = FeignConfiguration.class)
public interface UserRestService {
    @GetMapping(value = "/internal/user/{username}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    UserDetailDto getUser(@PathVariable String username);
}
