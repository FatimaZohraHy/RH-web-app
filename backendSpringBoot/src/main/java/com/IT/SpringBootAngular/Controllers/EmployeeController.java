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
    @PutMapping("Reclamations/edit/{r_id}")
    public ResponseEntity<String> editEmployee(@PathVariable (name = "id") String id,
                                               @PathVariable (name = "r_id") String reclamation_id,
                                               @RequestBody Reclamation reclamation){
        return null;
    }
    //add reclamation
    @PostMapping("/Reclamations/add")
    public ResponseEntity<String> addRecalamation(@PathVariable String id,@RequestBody Reclamation reclamation){
        String message = reclamationService.saveReclamation(id,reclamation);
        return ResponseEntity.ok(message);
    }
    @GetMapping("/Reclamation/getAll")
    public ResponseEntity<List<Reclamation>> getAllReclamations(@PathVariable String id){
        List<Reclamation> message = reclamationService.getReclamationsOfEmployee(id);
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("/Reclamatons/delete/{r_id}")
    public ResponseEntity<String> deleteReclamation(@PathVariable (name="id") String employee_id,@PathVariable (name="r_id") String reclamation_id ){
        String message = reclamationService.deleteReclamationByEmployee(employee_id,reclamation_id);
        return ResponseEntity.ok(message);
    }
    //-------demandes part---------------



}
