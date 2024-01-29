package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        //    // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk()) // checks the reponse is ok, if not ok there is a problem and it gives error.
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))// set the operand1 key value to expected value 111
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))// set the operand2 key value to expected value 1010
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))// set the result key value to expected value 10001
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));// set the result key value to expected operator "add"
    }

    @Test
    // Test case 1
    public void add3() throws Exception {
        //    // its just checks the values sent to Json path are right values
        this.mvc.perform(get("/add_json").param("operand1","1110").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1110))// set the operand1 key value to expected value 1110
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))// set the operand2 key value to expected value 1111
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11101))// set the result key value to expected value 11101
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));// set the result key value to expected operator "add"
    }



    @Test
    // Test case 2
    public void add4() throws Exception {
        //    // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/add_json").param("operand1","1011").param("operand2","1010"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1011))// set the operand1 key value to expected value 1011
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))// set the operand2 key value to expected value 1010
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10101))// set the result key value to expected value 10101
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));// set the result key value to expected operator "add"
    }
    @Test
    // Test case 3
    public void add5() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/add_json").param("operand1","100").param("operand2","101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(100))// set the operand1 key value to expected value 100
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))// set the operand2 key value to expected value 101
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1001))// set the result key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));// set the result key value to expected operator "add"
    }

    @Test
    // OR test case 1
    public void OR1() throws Exception {
        // Performs
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/OR_json").param("operand1","1001").param("operand2","101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001)) // set the operand1 key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))// set the operand2 key value to expected value 101
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1101))// set the result key value to expected value 1101
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("OR"));// set the result key value to expected operator "OR"
    }
    @Test
    // OR test case 2
    public void OR2() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/OR_json").param("operand1","10000").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(10000))// set the operand1 key value to expected value 10000
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))// set the operand2 key value to expected value 1111
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11111))// set the result key value to expected value 11111
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("OR"));// set the result key value to expected operator "OR"
    }
    @Test
    // OR test case 3
    public void OR3() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/OR_json").param("operand1","1001").param("operand2","1101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001))// set the operand1 key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1101))// set the operand2 key value to expected value 1101
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1101))// set the result key value to expected value 1101
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("OR"));// set the result key value to expected operator "OR"
    }
    @Test
    // And test case 1
    public void AND1() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/And_json").param("operand1","1001").param("operand2","101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001))// set the operand1 key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))// set the operand2 key value to expected value 101
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))// set the result key value to expected value 0001(1)
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("And"));// set the result key value to expected operator "And"
    }

    @Test
    // And test case 2
    public void AND2() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/And_json").param("operand1","10000").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(10000))// set the operand1 key value to expected value 10000
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))// set the operand1 key value to expected value 1111
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))// set the result key value to expected value 0000
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("And"));// set the result key value to expected operator "And"
    }

    @Test
    // AND test case 3
    public void AND3() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/And_json").param("operand1","1001").param("operand2","1101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001))// set the operand1 key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1101))// set the operand1 key value to expected value 1101
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1001))// set the result key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("And"));// set the result key value to expected operator "And"
    }


    @Test
    // multiply test case 1
    public void Multi1() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/mulitply_json").param("operand1","1001").param("operand2","101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001))// set the operand1 key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))// set the operand1 key value to expected value 101
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(101101))// set the result key value to expected value 101101
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));// set the result key value to expected operator "multiply"
    }

    @Test
    // multiply test case 2
    public void Multi2() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/mulitply_json").param("operand1","10000").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(10000))// set the operand1 key value to expected value 10000
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))// set the operand1 key value to expected value 1111
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11110000))// set the result key value to expected value 11110000
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));// set the result key value to expected operator "multiply"
    }

    @Test
    // multiply test case 3
    public void Multi3() throws Exception {
        // its just checks the values sent to Json path are right values.
        this.mvc.perform(get("/mulitply_json").param("operand1","1001").param("operand2","1101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001))// set the operand1 key value to expected value 1001
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1101))// set the operand1 key value to expected value 1101
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1110101))// set the result key value to expected value 1110101
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));// set the result key value to expected operator "multiply"
    }




}