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

   // private DemandeRepo demandeRepo;
    @Autowired
    private ReclamationRepo reclamationRepo;

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
             }
             // Delete the employee
             repo.deleteById(id);
         }
     }




     public Employee getById(String id){
         return repo.findById(id).get();
     }

}
