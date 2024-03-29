package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Service.AuthService;
import com.IT.SpringBootAngular.dto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")

public class SignupController {
    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<String>signupUser(@RequestBody SignupRequest signupRequest){
        boolean isUserCreated = authService.createUser(signupRequest);
        if(isUserCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failde to Create user");
        }
    }
}
