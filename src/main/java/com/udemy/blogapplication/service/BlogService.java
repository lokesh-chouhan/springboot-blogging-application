package com.udemy.blogapplication.service;

import com.udemy.blogapplication.dto.BlogDto;

import java.util.List;

public interface BlogService {

    BlogDto createBlog(BlogDto blogDto);
    List<BlogDto> getAllBlogs(int pageNo, int pageSize);
    BlogDto getBlog(Long id);
    void deleteBlog(Long id);
}
