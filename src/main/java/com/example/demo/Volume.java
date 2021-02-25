package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController
public class Volume {

    @PostMapping("/math/area")
    public String getVolume(DoWork dw){return dw.getArea();}

}

/*
n your spring-playground application, create an endpoint which accepts POST requests to /math/area, that takes the following parameters:

type: can be circle or rectangle
radius: a number
width: a number
height: a number
Recall that the calculation for a circle is PI * radius^2

Circles require a radius. Rectangles require a width and height. If anything is invalid, render Invalid

Examples
POST /math/area

type=circle&radius=4
Would render Area of a circle with a radius of 4 is 50.26548
 */