package com.udemy.blogapplication.dto;

import lombok.Data;

@Data
public class BlogDto {
    private long id;
    private String title;
    private String description;
    private String content;

}
