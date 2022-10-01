package com.udemy.blogapplication.service;

import com.udemy.blogapplication.payload.BlogDto;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    BlogDto createBlog(BlogDto blogDto);
    List<BlogDto> getAllBlogs();
    BlogDto getBlog(Long id);
}
