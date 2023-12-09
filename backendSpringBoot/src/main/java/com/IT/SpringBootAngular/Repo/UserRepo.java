package com.IT.SpringBootAngular.Repo;

import com.IT.SpringBootAngular.Entitys.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
}
