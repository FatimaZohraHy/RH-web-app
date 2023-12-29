package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.dto.SignupRequest;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest);
}
