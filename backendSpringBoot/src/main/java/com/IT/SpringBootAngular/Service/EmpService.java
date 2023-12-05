package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
@Autowired
    private EmployeeRepo repo;


     public void save_update(Employee em){
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
