package com.IT.SpringBootAngular.Entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Salaire")
public class Salaire {
    @Id
    private String id;
    private  float salaire;
    private String pay_day;

    public Salaire() {
    }

    public Salaire(float salaire, String pay_day) {
        this.salaire = salaire;
        this.pay_day = pay_day;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getTime() {
        return pay_day;
    }

    public void setTime(String pay_day) {
        this.pay_day = pay_day;
    }
}
