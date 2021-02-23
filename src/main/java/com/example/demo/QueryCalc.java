package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class QueryCalc {


    @GetMapping("/math/calculate")
    public String getQueryCalc(@RequestParam String operation, @RequestParam int x, @RequestParam int y){

        HashMap<String,String> calc = new HashMap<>();
        calc.put("add", "+");
        calc.put("subtract", "-");
        calc.put("divide", "/");
        calc.put("multiply", "*");


        return x + " " + calc.get(operation) +" " + y + " = " + (x + y);

    }
}


