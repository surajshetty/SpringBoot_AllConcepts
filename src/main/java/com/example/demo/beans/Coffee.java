package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Coffee {
    @Id
    private final String id;
    private String name;

    public Coffee(String id,String name) {
        this.id = id;
        this.name = name;
    }
    public Coffee(String name){
        this(UUID.randomUUID().toString(),name);
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
