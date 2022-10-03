package com.udemy.blogapplication.controller;


import com.udemy.blogapplication.dto.BlogDto;
import com.udemy.blogapplication.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<BlogDto> getAllBlogs(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                     @RequestParam(defaultValue = "2", required = false) int pageSize){
        return blogService.getAllBlogs(pageNo, pageSize);
    }

    @PostMapping("")
    public BlogDto createBlog(@RequestBody BlogDto blog){
        return blogService.createBlog(blog);
    }

//    @PutMapping("")
//    public Blog updateBlog(@RequestBody Blog blog){
//        return blogRepository.save()
//    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id){
        blogService.deleteBlog(id);
    }

}
