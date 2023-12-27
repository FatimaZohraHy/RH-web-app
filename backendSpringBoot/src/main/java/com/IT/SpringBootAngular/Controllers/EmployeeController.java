package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Service.EmpService;
import com.IT.SpringBootAngular.Service.ReclamationService;
import com.IT.SpringBootAngular.Service.SalireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") //frontend connection
@RequestMapping("/employee/{id}")
public class EmployeeController {
    @Autowired
    private EmpService employeeService;
    @Autowired
    private ReclamationService reclamationService;

    //get employee by id
    @GetMapping()
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable String id){
        Employee message = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(message);
    }

    //edit his own info salary not included
    @PutMapping
    public ResponseEntity<String> editEmployee(@PathVariable String id){
        return null;
    }
    //add reclamation
    //delete reclamation
    //add demand
    //delete demand


}
