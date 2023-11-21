package com.IT.SpringBootAngular.Repo;

import com.IT.SpringBootAngular.Entitys.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee,String> {
}
