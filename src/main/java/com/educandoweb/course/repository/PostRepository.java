package com.educandoweb.course.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.domain.Post;

/*USER nome da classe e o tipo da ID string*/
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
