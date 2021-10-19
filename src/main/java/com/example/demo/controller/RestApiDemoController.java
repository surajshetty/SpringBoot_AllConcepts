package com.example.demo.controller;

import com.example.demo.beans.Coffee;
import com.example.demo.repository.DemoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiDemoController {
    //private List<Coffee> coffees = new ArrayList<>();
    private final DemoRepository repository;
    public RestApiDemoController (DemoRepository repository){
        System.out.println("comtroller........................");
        this.repository = repository;
       // this.repository.saveAll(List.of(new Coffee("mocha"),new Coffee("capachino")));
      //  coffees.addAll();
    }

    @RequestMapping(value="/coffees", method= RequestMethod.GET )
    // marshalling and unmarshalling will be done under the hood by jackson
    Iterable<Coffee> getCoffees(){
        return this.repository.findAll();
    }

    @GetMapping("/coffee/{name}")
    Optional<Coffee> getCoffee(@PathVariable  String name){
        System.out.println("name:"+name);
       /* Optional<Coffee> oc = ((List<Coffee>)this.getCoffees()).stream().filter(e->{
            System.out.println("========"+e.getName()+"========"+name+"======");
            return( e.getName().equalsIgnoreCase(name));
            }
           ).findFirst();

       // oc
        System.out.println("========XXXX"+oc);

        return oc;*/
        return repository.findById(name);

    }


}
