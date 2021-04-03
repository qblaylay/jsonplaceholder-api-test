package com.jsonplaceholder.model;

import lombok.Getter;

@Getter
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
