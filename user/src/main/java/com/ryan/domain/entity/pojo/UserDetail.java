package com.ryan.domain.entity.pojo;

import com.ryan.domain.constant.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userInfoId;
    private Long userId;
    private String bio;
    private String name;
    private Integer followers;
    private Integer following;
    private Integer numPosts;
    private String username;
    private UserStatus status;
    private String email;
    private String password;
}
