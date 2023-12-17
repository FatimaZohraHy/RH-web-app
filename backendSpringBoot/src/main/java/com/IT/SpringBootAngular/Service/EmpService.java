package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.*;
import com.IT.SpringBootAngular.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collections;
import java.util.zip.Adler32;

@Service
public class EmpService {
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private SalaireRepo Srepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ReclamationRepo reclamationRepo;
    @Autowired
    private HRadminRepo adminRepo;

   // private DemandeRepo demandeRepo;




























}
