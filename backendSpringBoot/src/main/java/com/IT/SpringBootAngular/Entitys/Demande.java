package com.IT.SpringBootAngular.Entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Demande")
public class Demande {
    @Id
    private String id;
    private String descrepsion;
    private boolean accepted = false;

    public Demande() {
    }

    public Demande(String id, String descrepsion) {
        this.id = id;

        this.descrepsion = descrepsion;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDescrepsion() {
        return descrepsion;
    }

    public void setDescrepsion(String descrepsion) {
        this.descrepsion = descrepsion;
    }
}
