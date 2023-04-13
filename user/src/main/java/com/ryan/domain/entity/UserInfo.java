package com.ryan.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_infos")
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userInfoId;

  @Column(unique = true)
  private Long userId;
  private String bio;
  private String name;
  private Integer followers;
  private Integer following;
  private Integer numPosts;
}
