package com.jsonplaceholder.model;

import lombok.Getter;

@Getter
public class Comment {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
