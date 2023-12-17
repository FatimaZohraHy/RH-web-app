package com.IT.SpringBootAngular.Entitys;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "Departement")
public class Departement {
    @Id
    private String id;
    private String departName ;
    private List<Employee> employeeList;
    public Departement(String departName) {
        this.departName = departName;
    }

    public Departement() {
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee emp){
        if (this.employeeList == null)
            this.employeeList = new ArrayList<>();
        employeeList.add(emp);
    }
    public String removeEmployee(Employee emp){
        try {
            employeeList.remove(emp);
        }catch (Exception e){
            e.printStackTrace();
            return "employee not exist in department";
        }
        return null;
    }

}
