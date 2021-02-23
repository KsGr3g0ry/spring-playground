package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pi {

    @GetMapping("/math/pi")
    public String getPi(){
        return "3.141592653589793";
    }
}


     /*
    takes a GET request to /math/pi
     renders the string 3.141592653589793
    */
    