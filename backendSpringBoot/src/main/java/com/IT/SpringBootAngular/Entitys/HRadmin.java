package com.IT.SpringBootAngular.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
   @JsonIgnore
   @DBRef
   private User user;
   @DBRef
   private List<Employee> employees;
   @DBRef
   private List<Departement> departements;

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
        return this.employees;
    }

    public List<Departement> getDepartements() {
        return this.departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
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

    public void removeEmployee(Employee emp){
        if(this.employees !=null)
         this.employees.remove(emp);
    }


    public void addDepartement(Departement departement){
        if(this.getDepartements()==null)
            this.departements=new ArrayList<>();
        this.departements.add(departement);
    }
    public void removeDepartement(Departement departement){
        if(this.departements!=null)
         this.departements.remove(departement);
    }

}
