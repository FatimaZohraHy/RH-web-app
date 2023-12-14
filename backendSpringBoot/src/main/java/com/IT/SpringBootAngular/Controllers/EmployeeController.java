package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Service.EmpService;
import com.IT.SpringBootAngular.Service.ReclamationService;
import com.IT.SpringBootAngular.Service.SalireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") //frontend connection
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmpService employeeService;
    @Autowired
    private ReclamationService reclamationService;





    //empolyee transactions
    @PutMapping(value ="/edit/{id}")
    private Employee updateEmployee(@RequestBody Employee employee ,  @PathVariable(name="id")String _id){
        employee.set_id(_id);
        employeeService.save_update(employee);return employee;
    }



    @RequestMapping("/employee/{id}")
    private Employee getEmployeeById(@PathVariable(name="id")String _id){
        return employeeService.getById(_id);
    }



    //Reclamation part

   @PostMapping("/reclamations/saveReclamation/{id}")
    public ResponseEntity<String> saveReclamation(@PathVariable String id , @RequestBody Reclamation reclamation){
        String result = reclamationService.saveReclamation(id,reclamation);
        return ResponseEntity.ok(result);
   }
}
