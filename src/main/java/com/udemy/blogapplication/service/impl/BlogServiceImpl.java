package com.udemy.blogapplication.service.impl;
import com.udemy.blogapplication.entity.Blog;
import com.udemy.blogapplication.dto.BlogDto;
import com.udemy.blogapplication.exception.ResourceNotFoundException;
import com.udemy.blogapplication.repository.BlogRepository;
import com.udemy.blogapplication.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog saved =  blogRepository.save(dtoToEntity(blogDto));
        return entityToDto(saved);
    }

    @Override
    public List<BlogDto> getAllBlogs() {

        

        return blogRepository.findAll().stream().map(blog -> entityToDto(blog)).collect(Collectors.toList());
    }

    @Override
    public BlogDto getBlog(Long id) {
         Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
         return entityToDto(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        blogRepository.delete(blog);
    }

    Blog dtoToEntity(BlogDto dto){
        Blog blog = new Blog();
        blog.setId(dto.getId());
        blog.setTitle(dto.getTitle());
        blog.setDescription(dto.getDescription());
        blog.setContent(dto.getContent());
        return blog;
    }

    BlogDto entityToDto(Blog blog){
        BlogDto dto = new BlogDto();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setDescription(blog.getDescription());
        dto.setContent(blog.getContent());
        return dto;
    }
}
