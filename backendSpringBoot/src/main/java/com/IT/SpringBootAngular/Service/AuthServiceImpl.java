package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Entitys.Role;
import com.IT.SpringBootAngular.Repo.HRadminRepo;
import com.IT.SpringBootAngular.dto.HRAdminRequest;
import com.IT.SpringBootAngular.dto.SignupRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService{
    private final HRadminRepo hRadminRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(HRadminRepo hRadminRepo, PasswordEncoder passwordEncoder) {
        this.hRadminRepo = hRadminRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createHRAdmin(HRAdminRequest hrAdminRequest) {
        // Check if HR admin already exists by email
        if (hRadminRepo.existsByEmail(hrAdminRequest.getEmail())) {
            return false;
        }

        // Create a new User entity and copy properties from HRAdminRequest
        HRadmin hRadmin = new HRadmin();
        BeanUtils.copyProperties(hrAdminRequest, hRadmin);

        // Set user role
        Role adminRole = hrAdminRequest.setRole(Role.ADMIN);
        hRadmin.setRoles(Collections.singleton(adminRole));

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(hrAdminRequest.getPassword());
        hRadmin.setPassword(hashedPassword);

        // Save the user
        hRadminRepo.save(hRadmin);

        // Optionally, you can return the created user or its ID if needed
        // return user.getId();
        return true;
    }
    @Override
    public boolean createUser(SignupRequest signupRequest) {
        return true;
    }

}
