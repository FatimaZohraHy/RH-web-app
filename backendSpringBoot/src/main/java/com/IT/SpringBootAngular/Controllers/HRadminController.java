package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Service.EmpService;
import com.IT.SpringBootAngular.Service.HRadminService;
import com.IT.SpringBootAngular.Service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/{id}")
public class HRadminController {

    @Autowired
    private HRadminService adminService;
    @Autowired
    private EmpService employeeService;
    @Autowired
    private ReclamationService reclamationService;
    //handle admin profile
    @GetMapping()
    public HRadmin getAdminById(@PathVariable String id){
        return adminService.getAdminById(id);
    }
    //handle des departements









    //imma remove it



    @GetMapping("/employee/getAll")
    public List<Employee> getAllEmployee(@PathVariable String id){
        return adminService.getAllEmployees(id);
    }
    //can not edit departement here ?? idk yet


}

