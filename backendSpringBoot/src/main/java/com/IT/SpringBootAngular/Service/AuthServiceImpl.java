package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Entitys.Role;
import com.IT.SpringBootAngular.Entitys.User;
import com.IT.SpringBootAngular.Repo.HRadminRepo;
import com.IT.SpringBootAngular.Repo.UserRepo;
import com.IT.SpringBootAngular.dto.HRAdminRequest;
import com.IT.SpringBootAngular.dto.SignupRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final HRadminRepo hRadminRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepo userRepo, HRadminRepo hRadminRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.hRadminRepo = hRadminRepo;
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

        Role userRole = signupRequest.getRole();
        user.setRoles(Collections.singleton(userRole));

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepo.save(user);
//        user.setId(createdUser.getId());
        return true;
    }

    @Override
    @Transactional
    public boolean createHRAdmin(HRAdminRequest hrAdminRequest) {
        // Check if HR admin already exists by email
        if (userRepo.existsByEmail(hrAdminRequest.getEmail())) {
            return false;
        }

        // Create a new User entity and copy properties from HRAdminRequest
        User user = new User();
        BeanUtils.copyProperties(hrAdminRequest, user);

        // Set user role
        Role adminRole = hrAdminRequest.getRole();
        user.setRoles(Collections.singleton(adminRole));

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(hrAdminRequest.getPassword());
        user.setPassword(hashedPassword);



        // Create an associated HRadmin
        HRadmin hradmin = new HRadmin();
        hradmin.setUser(user);
        // Set other HRadmin properties if needed
        hradmin.setFirstname(hrAdminRequest.getFirstname());
        hradmin.setLastname(hrAdminRequest.getLastname());
        hradmin.setEntreprise(hrAdminRequest.getEntreprise());
        // Save the user
        user.sethRadmin(hradmin);
        userRepo.save(user);
        // Save the HRadmin
        hRadminRepo.save(hradmin);

        // Optionally, you can return the created user or its ID if needed
        // return user.getId();
        return true;
    }



}
