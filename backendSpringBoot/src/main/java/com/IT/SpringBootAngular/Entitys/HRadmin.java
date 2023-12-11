package com.IT.SpringBootAngular.Entitys;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HRadmin")
public class HRadmin extends User{
    public HRadmin() {
        super();
    }
    public HRadmin(String _id, String username, String email, String password) {
        super(_id, username, email, password);
    }

}
