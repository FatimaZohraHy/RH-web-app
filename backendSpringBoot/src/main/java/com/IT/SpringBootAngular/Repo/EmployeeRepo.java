package com.IT.SpringBootAngular.Repo;

import com.IT.SpringBootAngular.Entitys.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

<<<<<<< HEAD
public interface EmployeeRepo extends MongoRepository<Employee,String> {
=======
import java.util.Optional;

public interface EmployeeRepo extends MongoRepository<Employee,String> {
     boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);
>>>>>>> HRMS-web-app
}
