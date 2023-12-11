package com.IT.SpringBootAngular.Entitys;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Reclamation")
public class Reclamation {
    private String reclamation;
}
