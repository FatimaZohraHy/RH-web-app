package com.IT.SpringBootAngular.Entitys;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.concurrent.RecursiveAction;

@Document(collection = "employees")
public class Employee {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private String address;
    private String city;
    private String state;
    private String department;
    private Date hireDate;

    private boolean isActive;

    @DBRef
    private User user;
    @DBRef
    private Salaire salaire;
    @DBRef
    private List<Reclamation> reclamation;

    public Employee(String _id, String firstName, String lastName, String position, String email, String phoneNumber, Date birthDate, String address, String city, String state, String department, Date hireDate,  boolean isActive,Salaire salaire , List<Reclamation> reclamation) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.state = state;
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
        this.salaire = salaire;
        this.reclamation = reclamation;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }





    public List<Reclamation> getReclamation() {
        return reclamation;
    }

    public void setReclamation(List<Reclamation> reclamation) {
        this.reclamation = reclamation;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }





    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Salaire getSalaire() {
        return salaire;
    }

    public void setSalaire(Salaire salaire) {
        this.salaire = salaire;
    }


    public void addReclamation(Reclamation r){
        if (this.reclamation == null) {
            this.reclamation = new ArrayList<>();
        }
        this.reclamation.add(r);
    }
    public void removeReclamation(Reclamation r){
        this.reclamation.remove(r);
    }
}
