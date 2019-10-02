package com.educandoweb.course.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.educandoweb.course.domain.User;

/*USER nome da classe e o tipo da ID string*/
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
