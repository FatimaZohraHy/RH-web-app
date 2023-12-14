package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Entitys.Demande;
import com.IT.SpringBootAngular.Entitys.User;
import com.IT.SpringBootAngular.Entitys.Salaire;
import com.IT.SpringBootAngular.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collections;
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

   // private DemandeRepo demandeRepo;

     public void save_update(Employee em) {
         User saveUser = userRepo.save(em.getUser());
         Salaire saveSalire = Srepo.save(em.getSalaire());
         //List<Reclamation> reclamations = em.getReclamation() != null ? em.getReclamation() : Collections.emptyList();
         //List<Reclamation> savedReclamations = reclamationRepo.saveAll(em.getReclamation());

         em.setUser(saveUser);
         em.setSalaire(saveSalire);

         //em.setReclamation(savedReclamations);
         repo.save(em);
     }
     public String edit(Employee updtatedemployee , String id){
         Employee employee = repo.findById(id).orElse(null);
         if(employee!=null){
             updtatedemployee.setUser(employee.getUser());
             updtatedemployee.setSalaire(employee.getSalaire());
             updtatedemployee.setReclamation(employee.getReclamation());
             repo.save(updtatedemployee);
             return id;

         }else{
             return "employee does not exist";
         }
     }

     public Iterable<Employee> getAll(){
         return this.repo.findAll();
     }


     public void delete(String id){
         Employee employee = repo.findById(id).orElse(null);//get the employee by its ID
         if (employee != null) {
             // Delete associated Salary
             if (employee.getSalaire() != null) {
                 Srepo.deleteById(employee.getSalaire().getId());
                 userRepo.deleteById(employee.getUser().getId());
                 for(Reclamation r : employee.getReclamation()){
                     reclamationRepo.deleteById(r.getId());
                 }
             }
             // Delete the employee
             repo.deleteById(id);
         }
     }




     public Employee getById(String id){
         return repo.findById(id).get();
     }
















}
