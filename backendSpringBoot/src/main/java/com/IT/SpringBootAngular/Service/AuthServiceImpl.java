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
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService{
<<<<<<< HEAD
    @Autowired
    private final UserRepo userRepo;
    @Autowired
=======
>>>>>>> 139b8f46542ae272d53950903216730d9f6cdb55
    private final HRadminRepo hRadminRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(HRadminRepo hRadminRepo, PasswordEncoder passwordEncoder) {
        this.hRadminRepo = hRadminRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
<<<<<<< HEAD
    public boolean createUser(SignupRequest signupRequest) {
        //check if user already existe
        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            return false;
        }g
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
=======
>>>>>>> 139b8f46542ae272d53950903216730d9f6cdb55
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

<<<<<<< HEAD


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
=======
        // Save the user
        hRadminRepo.save(hRadmin);
>>>>>>> 139b8f46542ae272d53950903216730d9f6cdb55

        // Optionally, you can return the created user or its ID if needed
        // return user.getId();
        return true;
    }
    @Override
    public boolean createUser(SignupRequest signupRequest) {
        return true;
    }



}
