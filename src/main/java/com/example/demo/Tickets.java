package com.example.demo;

public class Tickets {
    private int price;
    private Person passenger;
    private int result = price + price;




    //getters and setters
    public int getPrice(){return price;}
    public void setPrice(int price){this.price = price;}
    public Person getPassenger(){return passenger;}
    public void setPassenger(Person passenger){this.passenger = passenger;}
    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }




    //constructor
    public Tickets(Person passenger,int price) {
        this.price = price;
        this.passenger = passenger;
    }
}
