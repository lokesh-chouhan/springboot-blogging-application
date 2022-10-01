package com.udemy.blogapplication.controller;


import com.udemy.blogapplication.entity.Blog;
import com.udemy.blogapplication.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/{id}")
    public Optional<Blog> getBlog(@PathVariable Long id){
        //return new Blog("topic","this is blog "+id);
        return blogRepository.findById(id);
    }

    @GetMapping("")
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @PostMapping("")
    public Blog createBlog(@RequestBody Blog blog){
        return blogRepository.save(blog);
    }

    @PutMapping("")
    public Blog updateBlog(Blog blog){
        return blog;
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id){
         blogRepository.deleteById(id);
    }

}
