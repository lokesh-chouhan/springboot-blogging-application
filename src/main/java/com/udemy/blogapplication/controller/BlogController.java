package com.udemy.blogapplication.controller;


import com.udemy.blogapplication.entity.Blog;
import com.udemy.blogapplication.payload.BlogDto;
import com.udemy.blogapplication.repository.BlogRepository;
import com.udemy.blogapplication.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {


    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{id}")
    public BlogDto getBlog(@PathVariable Long id){
        //return new Blog("topic","this is blog "+id);
        return blogService.getBlog(id);
    }


    @GetMapping("")
    public List<BlogDto> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @PostMapping("")
    public BlogDto createBlog(@RequestBody BlogDto blog){
        return blogService.createBlog(blog);
    }

//    @PutMapping("")
//    public Blog updateBlog(@RequestBody Blog blog){
//        return blogRepository.save()
//    }

//    @DeleteMapping("/{id}")
//    public void deleteBlog(@PathVariable Long id){
//         blogRepository.deleteById(id);
//    }

}
