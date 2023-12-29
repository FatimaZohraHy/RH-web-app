package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.User;
import com.IT.SpringBootAngular.Repo.UserRepo;
import com.IT.SpringBootAngular.dto.SignupRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(SignupRequest signupRequest) {
        //check if user already existe
        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            return false;
        }
        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);
//        user.setEmail(signupRequest.getEmail());
//        user.setUsername(signupRequest.getUsername());

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepo.save(user);
//        user.setId(createdUser.getId());
        return true;

    }
}
