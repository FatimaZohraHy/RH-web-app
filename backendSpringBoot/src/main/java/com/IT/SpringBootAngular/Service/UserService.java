package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.User;
import com.IT.SpringBootAngular.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Iterable<User> getAll(){
        return this.repo.findAll();
    }
}
