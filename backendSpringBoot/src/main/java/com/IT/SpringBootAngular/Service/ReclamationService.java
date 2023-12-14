package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Repo.EmployeeRepo;
import com.IT.SpringBootAngular.Repo.ReclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

@Service
public class ReclamationService {
    @Autowired
    private ReclamationRepo reclamationRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Reclamation> getAllReclamations(){
        return reclamationRepo.findAll();
    }
    public Reclamation getReclamationById(String id){
        return reclamationRepo.findById(id).orElse(null);
    }
    public String saveReclamation(String employee_id, Reclamation reclamation) {
        Employee employee = employeeRepo.findById(employee_id).orElse(null);
        if (employee != null) {
            employee.addReclamation(reclamation);
            employeeRepo.save(employee);
            reclamationRepo.save(reclamation);
            return "Reclamation added successfully";
        } else {
            return "Employee not found";
        }
    }

    public List<Reclamation> getReclamationsOfEmployee(String employee_id){
        Employee employee = employeeRepo.findById(employee_id).orElse(null);
        return employee.getReclamation();
    }

    public Reclamation updateReclamation(String emp_id , RecursiveAction updatedReclamation ){
        return null;
    }
    public void deleteReclamation(String id){
        reclamationRepo.deleteById(id);
    }
}
