package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Coffee {
    @Id
    private  String id;
    private String name;
    public Coffee() {
        this.id = UUID.randomUUID().toString();

    }
    public Coffee(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
