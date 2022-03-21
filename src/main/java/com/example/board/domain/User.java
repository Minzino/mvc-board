package com.example.board.domain;

public class User {
    private Long id;
    private String userId;
    private String password;
    private String name;

    public User(Long id, String userId, String password, String name) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
}
