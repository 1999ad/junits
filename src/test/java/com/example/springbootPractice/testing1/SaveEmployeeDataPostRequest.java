package com.example.springbootPractice.testing1;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springbootPractice.Controller.EmplloyeeController;
import com.example.springbootPractice.Service.EmployeeService;
import com.example.springbootPractice.entity.EmployeeEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmplloyeeController.class)
public class SaveEmployeeDataPostRequest {
	
	@Autowired
	MockMvc  mockMvc;
	
	@MockBean
	EmployeeService employeeService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	//used to convert json to java and vice versa
	
	@Test
	public void saveDataTest() throws JsonProcessingException, Exception {
		
		EmployeeEntity e= new EmployeeEntity();
		e.setId(1);
		e.setName("Aditi");
		e.setSalary(100000);
		
		when(employeeService.saveData(any(EmployeeEntity.class))).thenReturn(e);
		//any-any argument ,instance of EmployeeEntity type is acceptable in this
		
		
		mockMvc.perform(post("/employee/saveEmployeeData")
				.contentType(MediaType.APPLICATION_JSON)//it will accept data in json format
                .content(objectMapper.writeValueAsString(e)))//convert java to json
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))//checks if id field has value 1
                .andExpect(jsonPath("$.name").value("Aditi"))
                .andExpect(jsonPath("$.salary").value(100000));
	}

}
