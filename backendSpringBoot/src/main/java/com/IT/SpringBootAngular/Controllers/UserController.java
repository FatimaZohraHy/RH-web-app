package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.User;
import com.IT.SpringBootAngular.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") //frontend connection
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value="/getAll")
    public Iterable<User> getUser(){
        return userService.getAll();
    }
}
