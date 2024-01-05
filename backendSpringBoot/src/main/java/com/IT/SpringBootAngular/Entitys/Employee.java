package com.IT.SpringBootAngular.Entitys;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.concurrent.RecursiveAction;

@Document(collection = "employees")
public class Employee {
    @Id
    private String _id =new ObjectId().toString();;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private String address;
    private String city;
    private String state;
    private Date hireDate;

    private boolean isActive;

    @DBRef
    private User user;
    @DBRef
    private Salaire salaire;
    @DBRef
    private List<Reclamation> reclamation;
    @DBRef
    //bcz it is Many to one association -_- and to skip the infinite loop
    @JsonIgnore
    private HRadmin admin;
    @DBRef
    @JsonIgnore
    private Departement departement;
    public Employee(String firstName, String lastName, String position, String email, String phoneNumber, Date birthDate, String address, String city, String state, Date hireDate,  boolean isActive,Salaire salaire , List<Reclamation> reclamation ,Departement departement ,HRadmin admin) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.state = state;
        this.hireDate = hireDate;
        this.isActive = isActive;
        this.salaire = salaire;
        this.reclamation = reclamation;
        this.admin = admin;
        this.departement = departement;
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
        return this.reclamation;
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

    public HRadmin getAdmin() {
        return admin;
    }

    public void setAdmin(HRadmin admin) {
        this.admin = admin;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
