package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class FlightTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testFlightt() throws Exception {
        this.mvc.perform(get("/flights/flight"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.tickets[0].price", is(200)));

    }


    @Test
    public void testFlightts() throws Exception {
        this.mvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[1].tickets[0].price", is(400)));

    }

    @Test
    public void testTicketSerialized() throws Exception { //serialized json data
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> info = new HashMap<>();
        info.put("firstName","some name");
        info.put("lastName","some other name");
        info.put("price",200);

        String json = objectMapper.writeValueAsString(info);

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    public void testTicketLiteral() throws Exception{ //json sent as String literal
        String json = "{\"tickets\": [ {\"passenger\": {\"firstName\": \"Some name\",\"lastName\": \"Some other name\" },\"price\": 200 },{\"passenger\": {\"firstName\": \"Name B\",\"lastName\": \"Name C\" },\"price\": 150 } ]}";
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.result",350));

    }

    @Test
    public void testTicketFileFixture() throws Exception{ //file fixture json data
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder requests = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(requests)
                .andExpect(status().isOk())
                .andExpect(content().string(json));
    }
    private String getJSON(String path) throws Exception{
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
