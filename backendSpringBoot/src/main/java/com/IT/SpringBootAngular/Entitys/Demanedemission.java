package com.IT.SpringBootAngular.Entitys;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "Demande")
public class Demanedemission extends Demande{
    private Date leave_date;

    public Demanedemission(Date leave_date) {
        this.leave_date = leave_date;
    }

    public Demanedemission(String id, String descrepsion, Date leave_date) {
        super(id, descrepsion);
        this.leave_date = leave_date;
    }


    public Date getLeave_date() {
        return leave_date;
    }

    public void setLeave_date(Date leave_date) {
        this.leave_date = leave_date;
    }
}
