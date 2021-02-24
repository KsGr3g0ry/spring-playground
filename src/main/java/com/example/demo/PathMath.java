package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController
public class PathMath {

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
        return "The volume of a " + length + "x" + width + "x" + height + " rectangle is " +
                Integer.toString(length * width * height);

    }
}
/*
Examples
POST /math/volume/3/4/5 should render the result
    private int length;
    private int width;
    private int height;
    // int volume = length * width * height;


    /*public int getLength(){return length;}
    public void setLength(int length){this.length = length;}

    public int getWidth(){return width;}
    public void setWidth(int width){this.width = width;}

    public int getHeight(){return height;}
    public void setHeight(int height){this.height = height;}
*/

