package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.*;
import com.IT.SpringBootAngular.Service.DemandeService;
import com.IT.SpringBootAngular.Service.EmpService;
import com.IT.SpringBootAngular.Service.HRadminService;
import com.IT.SpringBootAngular.Service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;
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
    @Autowired
    private DemandeService demandeService;
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
    public ResponseEntity<Map<String,Reclamation>> getAllReclamations(@PathVariable String id){
      Map<String,Reclamation> message = reclamationService.getAllReclamations(id);
      return ResponseEntity.ok(message);
    }
    //---------------------------------------------------------------------------
    //get all resign demand by employee name
    @GetMapping("/requests/resignations/getAll")
    public ResponseEntity<Map<String, Demande>> getAllResignRequests(@PathVariable String id){
        Map<String,Demande> message = demandeService.getAllResignationDemands(id);
        return ResponseEntity.ok(message);
    }
    //accept
    @PutMapping("request/resign/accept/{r_id}")
    public void acceptResignDemande(@PathVariable (name = "id") String id , @PathVariable (name = "r_id") String r_id){

    }
    //refuse
    @PutMapping("request/resign/refuse/{r_id}")
    public void refuseResignDemande(@PathVariable (name = "id") String id , @PathVariable (name = "r_id") String r_id){}


    //get all vacation demands of employees
    @GetMapping("/request/vacation/")
    public ResponseEntity<Map<String, DemandeConge>> getAllVacationDemands(@PathVariable String id){
        return null;
    }

    //accept


    //refuse

    }