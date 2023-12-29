package com.IT.SpringBootAngular.Repo;

import com.IT.SpringBootAngular.Entitys.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
//        Optional<User>findByUsername(String username);
        boolean existsByEmail(String email);
        Optional<User> findByEmail(String email);
}
