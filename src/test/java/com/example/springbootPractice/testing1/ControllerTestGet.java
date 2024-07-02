package com.example.springbootPractice.testing1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springbootPractice.Controller.EmplloyeeController;
import com.example.springbootPractice.Service.EmployeeService;

@WebMvcTest(EmplloyeeController.class)
public class ControllerTestGet {
	
	@Autowired
	private MockMvc mockMvc;//s used to perform HTTP requests to test the controller endpoints.
	
	@MockBean
    private EmployeeService employeeService;
	
	@Test
	public void hiiTest() throws Exception  {
		
		mockMvc.perform(get("/employee/hello"))
		       .andExpect(status().isOk())//checks if condition is true or not
		       .andExpect(content().string("hello for testing"));//this will run as output is same
		      // .andExpect(content().string("hello"));//if i write this line it will give error as expected output in my controller is different
	}
}
