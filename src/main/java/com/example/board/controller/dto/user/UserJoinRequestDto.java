package com.example.board.controller.dto.user;

import com.example.board.domain.User;

public class UserJoinRequestDto {
    private Long id;
    private String userId;
    private String password;
    private String name;

    public UserJoinRequestDto(Long id, String userId, String password, String name) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public User toEntity() {
        return new User(id, userId, password, name);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
