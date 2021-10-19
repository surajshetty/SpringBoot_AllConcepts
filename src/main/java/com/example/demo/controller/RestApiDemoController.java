package com.example.demo.controller;

import com.example.demo.beans.Coffee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();
    public RestApiDemoController (){
        System.out.println("comtroller........................");
        coffees.addAll(List.of(new Coffee("mocha"),new Coffee("capachino")));
    }

    @RequestMapping(value="/coffees", method= RequestMethod.GET )
    // marshalling and unmarshalling will be done under the hood by jackson
    Iterable<Coffee> getCoffees(){
        return coffees;
    }

    @GetMapping("/coffee/{name}")
    Optional<Coffee> getCoffee(@PathVariable  String name){
        System.out.println("name:"+name);
        Optional<Coffee> oc = coffees.stream().filter(e->{
            System.out.println("========"+e.getName()+"========"+name+"======");
            return( e.getName().equalsIgnoreCase(name));
            }
           ).findFirst();

       // oc
        System.out.println("========XXXX"+oc);

        return oc;

    }
public static void main(String args[]){
    RestApiDemoController controller = new RestApiDemoController();
    Optional<Coffee> oc = controller.getCoffee("mocha");
    System.out.println(oc.orElse(new Coffee("")).getName());
}

}
