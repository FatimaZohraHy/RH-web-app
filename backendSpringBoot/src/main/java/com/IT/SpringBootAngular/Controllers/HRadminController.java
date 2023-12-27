package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Service.EmpService;
import com.IT.SpringBootAngular.Service.HRadminService;
import com.IT.SpringBootAngular.Service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/get")
    public ResponseEntity<HRadmin> getAdminById(@PathVariable String id){
        HRadmin message = adminService.getAdminById(id);
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAdmin(@PathVariable String id){
        String message = adminService.deleteAdmin(id);
        return ResponseEntity.ok(message);
    }
    @GetMapping("/employee/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(@PathVariable String id){

        List<Employee>message = employeeService.getAllEmployee(id);
        return ResponseEntity.ok(message);
    }

    //get all reclamation by employee name
    @GetMapping("/reclamations")
    public ResponseEntity<Map<Employee,Reclamation>> getAllReclamations(@PathVariable String id){
        Map<Employee,Reclamation> message = reclamationService.getAllReclamations(id);
        return ResponseEntity.ok(message);
    }
    //get all demandes by employee name

}

