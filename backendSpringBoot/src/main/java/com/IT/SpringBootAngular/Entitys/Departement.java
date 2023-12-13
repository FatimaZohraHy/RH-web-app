package com.IT.SpringBootAngular.Entitys;

public class Departement {
    private String departName;
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
}
