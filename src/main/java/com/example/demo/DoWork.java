package com.example.demo;

import static java.lang.Math.PI;

public class DoWork {

    String type = "";
    int radius;
    int height;
    int width;
    double area;
    double pi = 3.14159;
    int vol;

    public String getArea(){

            if(type == "circle"){
                area = pi * (radius * radius);
                return "Area of a " + type + " with a radius of " + radius + " is " + area;//PI * radius ^2
            } else if (type == "rectangle"){
                vol = width * height;
                return "Area of a " + width + "x" + height + " " + type + " is " + vol;
            } else{
                return "Invalid";
            }

      //String s = String.valueOf(area);
      //return "Area of a " + type + " with a radius of " + radius + " is " + s;

    }





    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
    /* In your spring-playground application, create an endpoint which accepts POST requests to
        /math/area, that takes the following parameters:

        type: can be circle or rectangle
        radius: a number
        width: a number
        height: a number
        Recall that the calculation for a circle is PI * radius^2

        Circles require a radius. Rectangles require a width and height. If anything is invalid,
           render Invalid

        Examples
        POST /math/area

        type=circle&radius=4
        Would render Area of a circle with a radius of 4 is 50.26548
        */