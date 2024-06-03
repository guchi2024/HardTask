package com.sparta.hardtask.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequest {

    private String comment;
    private String username;

    public CommentCreateRequest(String comment, String username) {
        this.comment = comment;
        this.username = username;
    }

}