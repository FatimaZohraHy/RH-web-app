package com.IT.SpringBootAngular.Entitys;
import org.springframework.data.mongodb.core.mapping.Document;

import  java.util.Date;
@Document(collection = "Demande")
public class DemandeConge extends Demande {
    private Date startDate;
    private Date endDate;


    public DemandeConge(String id, String descrepsion, Date startDate, Date endDate) {
        super(id, descrepsion);
        this.startDate = startDate;
        this.endDate = endDate;
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

}
