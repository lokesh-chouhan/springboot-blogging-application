package com.udemy.blogapplication.repository;

import com.udemy.blogapplication.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog,Long> {

}
