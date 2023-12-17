package com.IT.SpringBootAngular.Entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "HRadmin")
public class HRadmin {
   @Id
    private String id;
   private String firstname;
   private String lastname;
   private String entreprise;
   @DBRef
   private User user;
   @DBRef
   private List<Employee> employees;


    public HRadmin() {
    }

    public HRadmin(String id,String fname,String lname,String entreprise, User user, List<Employee> employees) {
        this.id = id;
        this.user = user;
        this.firstname = fname;
        this.entreprise = entreprise;
        this.lastname = lname;
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        if(this.getEmployees()==null){
            this.employees = new ArrayList<>();
        }
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        this.employees.remove(employee);
    }
}
