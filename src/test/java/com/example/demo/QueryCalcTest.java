package com.example.demo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(QueryCalc.class)
public class QueryCalcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testQueryCalc() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));

    }

}


/*In your spring-playground application, create an endpoint that takes GET requests to /math/calculate, which
takes 3 query parameters:

operation: Which can be add, subtract, multiply, divide (optional)
x: A number (required)
y: A number (required)*/