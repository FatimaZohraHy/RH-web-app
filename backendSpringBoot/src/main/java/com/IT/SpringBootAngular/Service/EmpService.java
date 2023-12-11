package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.User;
import com.IT.SpringBootAngular.Entitys.Salaire;
import com.IT.SpringBootAngular.Repo.EmployeeRepo;
import com.IT.SpringBootAngular.Repo.SalaireRepo;
import com.IT.SpringBootAngular.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private SalaireRepo Srepo;
    @Autowired
    private UserRepo userRepo;

    private SalireService salaireservice;

     public void save_update(Employee em){
         User saveUser = userRepo.save(em.getUser());
         Salaire saveSalire = Srepo.save(em.getSalaire());
         em.setUser(saveUser);
         em.setSalaire(saveSalire);
         repo.save(em);




     }

     public Iterable<Employee> getAll(){
         return this.repo.findAll();
     }


     public void delete(String id){
         repo.deleteById(id);
     }


     public Employee getById(String id){
         return repo.findById(id).get();
     }

}
