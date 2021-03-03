package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class FlightController {

    @GetMapping("/flights/flight")
    public Flight getFlight() {
        Person newPassenger = new Person("Jim","Jones"); //create new person

        Tickets newTicket = new Tickets(newPassenger,200); //create new ticket

        List<Tickets> ticketList = List.of(newTicket); //create new List

        Flight newFlight = new Flight(new Date(), ticketList); //new flight

        return newFlight;

    }

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        Person newPassenger = new Person("Jimmy","Jones"); //create new person
        Person newPassenger1 = new Person("Jimmy", null);

        Tickets newTicket = new Tickets(newPassenger,200); //create new ticket
        Tickets newTicket1 = new Tickets(newPassenger1, 400);

        List<Tickets> ticketList = List.of(newTicket); //create new List
        List<Tickets> ticketList1 = List.of(newTicket1);

        Flight newFlight = new Flight(new Date(), ticketList); //new flight
        Flight newFlight1 = new Flight(new Date(), ticketList1);

        return Arrays.asList(newFlight, newFlight1);

    }

    @PostMapping("/flights/tickets/total")
    public void getTotal(@RequestBody Flight flights){ //class that has the properties to access

    }


    }

