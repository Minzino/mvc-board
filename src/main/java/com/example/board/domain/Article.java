package com.example.board.domain;

public class Article {
    private Long id;
    private String title;
    private String writer;
    private String contents;

    public Article(Long id, String title, String writer, String contents) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
    }
}
