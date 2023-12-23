package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Departement;
import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Service.DepartementService;
import com.IT.SpringBootAngular.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/{id}/departement")
public class DepartementController {
    @Autowired
    private DepartementService departementService;

    @Autowired
    private EmpService empService;



    //handle Departements
    //---------------------------------------

    @PostMapping("/add")
    public ResponseEntity<String> addDepartement(@PathVariable String id, @RequestBody Departement departement){
         String message = departementService.addDepartement(id,departement);
         return  ResponseEntity.ok(message);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Departement>> getAllDepartement(@PathVariable (name = "id") String id){
        List<Departement> message = departementService.getAllDepartements(id);
        return ResponseEntity.ok(message);
    }
    //--------------------------------------

    @DeleteMapping("/delete/{d_id}")
    public ResponseEntity<String> deleteDepartement(@PathVariable (name="id") String  admin_id ,
                                         @PathVariable (name = "d_id") String departement_id ){
        String message =  departementService.deleteDepartement(admin_id,departement_id);
        return ResponseEntity.ok(message);
    }
    //Still
    @PutMapping("/edit/{d_id}")
    public ResponseEntity<String> editDepartement(@PathVariable  (name="id") String  admin_id ,
                                       @PathVariable (name = "d_id") String departement_id,@RequestBody Departement departement ){
      String message = departementService.editDepartement(admin_id,departement_id,departement);
        return ResponseEntity.ok(message);
    }


    //handle employees by departements

    @PostMapping("/{d_id}/employee/add")
    public ResponseEntity<String> addEmployee(@PathVariable (name="id") String admin_id ,
                            @PathVariable (name = "d_id") String departement_id,
                            @RequestBody Employee employee){
        String message =  empService.addEmployeeByDepartemnt(admin_id,departement_id,employee);
        return ResponseEntity.ok(message);
    }


    @DeleteMapping("/{d_id}/employee/delete/{e_id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable (name="id") String admin_id ,
                                   @PathVariable (name = "d_id") String departement_id,
                                   @PathVariable (name ="e_id") String employee_id){
       String message = empService.deleteEmployeeBydepartement(admin_id,departement_id,employee_id);
       return ResponseEntity.ok(message);
    }

    @GetMapping("/{d_id}/employee/getALL")
    public ResponseEntity<List<Employee>> getAllEmpoyee(@PathVariable (name="id") String  admin_id ,
                                        @PathVariable (name = "d_id") String departement_id ){
        List<Employee> message = empService.getAllEmployeeByDepartement(admin_id,departement_id);
        return ResponseEntity.ok(message);
    }


    //still
    @PutMapping("/{d_id}/employee/edit/{e_id}")
    public String editEmployee(@PathVariable (name="id") String admin_id ,
                                 @PathVariable (name = "d_id") String departement_id,
                                 @PathVariable (name = "e_id") String employee_id,
                                 @RequestBody Employee employee){
        return empService.editEmployeeByDepartement(admin_id,departement_id,employee_id,employee);
    }

}
