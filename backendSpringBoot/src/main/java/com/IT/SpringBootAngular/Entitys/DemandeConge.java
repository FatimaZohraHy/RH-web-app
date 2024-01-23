package com.IT.SpringBootAngular.Entitys;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import  java.util.Date;
@Document(collection = "conge")
public class DemandeConge {
    @Id
    private String id = new ObjectId().toString();
    private Date startDate;
    private Date endDate;
    private String descrepsion;
    private  String state = "No action yet";
    public DemandeConge() {
    }

    public DemandeConge(String id, String descrepsion, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.descrepsion = descrepsion;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
