package com.example.demo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Flight {
    //properties
    private Date departs;

    public Flight(Date departs, List<Tickets> tickets) {
        this.departs = departs;
        this.tickets = tickets;
    }

    private List<Tickets> tickets;

    //tickets at the top with passenger and price. passenger has under it with passenger
    // with firstName, lastName.
    /*static class Tickets{
        private int price;

        public int getPrice(){return price;}
        public void setPrice(int price){this.price = price;}*/
    //}







    //getter and setters
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public Date getDeparts() {
        return departs;
    }
    public void setDeparts(Date departs) {
        this.departs = departs;
    }
    public List<Tickets> getTickets() {
        return tickets;
    }
    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }


    //constructor
}
