package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/")) // just perform a get request to "/"
            .andExpect(status().isOk())// checks the replonse is ok, if not ok there is a problem and it gives error.
            .andExpect(view().name("calculator"))// checks if the repsonse uses calculator.html template
			.andExpect(model().attribute("operand1", "")) // set attribute operand 1 of calculator templete
			.andExpect(model().attribute("operand1Focused", false)); // set attribute operand FOcused
    }
	
	    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }
	@Test
	    public void postParameter() throws Exception {
        // its just checks the operand 1, operator, and operand value 2 is set to the right values
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))
            .andExpect(status().isOk()) // checks the replonse is ok, if not ok there is a problem and it gives error.
            .andExpect(view().name("result"))// checks if the reposponse uses result.html template
			.andExpect(model().attribute("result", "1110")) // checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
			.andExpect(model().attribute("operand1", "111"));//checks if the attribute operand1 is set to 111
    }

    @Test
    // Test case 1
    public void postParameter1() throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","1110").param("operator","+").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(view().name("result")) // checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "11101")) // checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1110"));//checks if the attribute operand1 is set to 1110
    }

    @Test
    // Test case 2
    public void postParameter2() throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","1011").param("operator","+").param("operand2","1010"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(view().name("result"))// checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "10101"))// checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1011"));//checks if the attribute operand1 is set to 1110
    }
    // Test case 3
    @Test
    public void postParameter3() throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","100").param("operator","+").param("operand2","101"))//.andDo(print())
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(view().name("result"))// checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "1001"))//checks if the attribute result in the result template is set to the result
        //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "100"));//checks if the attribute operand1 is set to 100
    }
    // Test case 1
    @Test
    public void ORTest1 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","1001").param("operator","|").param("operand2","1010"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "1011"))//checks if the attribute result in the result template is set to the result
        //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1001"));    //checks if the attribute operand1 is set to 1001
    }

    @Test
    // Or tesr case 2
    public void ORTest2 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","10000").param("operator","|").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error.
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "11111"))//checks if the attribute result in the result template is set to the result
        //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "10000")); //checks if the attribute operand1 is set to 10000

    }

    @Test
    // Or test case 3
    public void ORTest3 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","1011").param("operator","|").param("operand2","1100"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "1111"))//checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1011"));//checks if the attribute operand1 is set to 1011

    }

    @Test
    // And test case 1
    public void AndTest1 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","1001").param("operator","&").param("operand2","101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "1"))//checks if the attribute result in the result template is set to the result
        //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1001"));//checks if the attribute operand1 is set to 1001

    }
    @Test
    // And test case 2
    public void AndTest2 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right values
        this.mvc.perform(post("/").param("operand1","10000").param("operator","&").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "0"))//checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "10000"));//checks if the attribute operand1 is set to 10000

    }

    @Test
    // And test case 3
    public void AndTest3 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right value.
        this.mvc.perform(post("/").param("operand1","1001").param("operator","&").param("operand2","1101"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "1001"))//checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1001"));//checks if the attribute operand1 is set to 1001

    }

    @Test
    // multiply test case 1
    public void multiplyTest1 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right value.
        this.mvc.perform(post("/").param("operand1","1001").param("operator","*").param("operand2","101"))//.andDo(print())
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "101101"))//checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1001"));//checks if the attribute operand1 is set to 1001

    }
    @Test
    // multiply test case 2
    public void multiplyTest2 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right value.
        this.mvc.perform(post("/").param("operand1","10000").param("operator","*").param("operand2","1111"))
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "11110000"))//checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "10000"));//checks if the attribute operand1 is set to 10000

    }
    @Test
    // multiply test case 3
    public void multiplyTest3 () throws Exception {
        // its just checks the operand 1, operator, and operand2 value is set to the right value.
        this.mvc.perform(post("/").param("operand1","1001").param("operator","*").param("operand2","1101"))//.andDo(print())
                .andExpect(status().isOk())// checks the reponse is ok, if not ok there is a problem and it gives error
                .andExpect(view().name("result"))//checks if the reposponse uses result.html template
                .andExpect(model().attribute("result", "1110101"))//checks if the attribute result in the result template is set to the result
                //  that user expects, just to check if the result produced by the code is same as the reuslt user expects.
                .andExpect(model().attribute("operand1", "1001"));//checks if the attribute operand1 is set to 10000

    }











}