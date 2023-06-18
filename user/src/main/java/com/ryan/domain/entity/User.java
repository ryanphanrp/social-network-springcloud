package com.ryan.domain.entity;

import com.ryan.domain.constant.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ofDefault();

    @Column(unique = true)
    private String email;
    private String password;
}

