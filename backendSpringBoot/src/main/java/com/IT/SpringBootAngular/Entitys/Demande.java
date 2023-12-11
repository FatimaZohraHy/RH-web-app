package com.IT.SpringBootAngular.Entitys;

import org.springframework.data.annotation.Id;

public class Demande {
    @Id
    private String id;
    private String Type;
    private String descrepsion;

    public Demande() {
    }

    public Demande(String id, String type, String descrepsion) {
        this.id = id;
        Type = type;
        this.descrepsion = descrepsion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescrepsion() {
        return descrepsion;
    }

    public void setDescrepsion(String descrepsion) {
        this.descrepsion = descrepsion;
    }
}
