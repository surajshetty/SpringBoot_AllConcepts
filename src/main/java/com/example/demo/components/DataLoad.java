package com.example.demo.components;

import com.example.demo.beans.Coffee;
import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoad {
    private final DemoRepository repository;

    public DataLoad(DemoRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void populateCoffees(){

        this.repository.saveAll(List.of(new Coffee("mocha"),new Coffee("capachino")));
    }
}
