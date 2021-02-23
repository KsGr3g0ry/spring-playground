package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MathSum {
    @PostMapping("/math/sum")
    public String getMathSum(@RequestParam(value = "n")List<String> params){

        int sum = 0;
        String output = "";

        for(String item:params) {
            sum += Integer.parseInt(item);
        }
        output = String.join(" + ", params);
        return output + " = " + Integer.toString(sum);

    }
}

