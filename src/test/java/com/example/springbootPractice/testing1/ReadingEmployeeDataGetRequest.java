package com.example.springbootPractice.testing1;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springbootPractice.Controller.EmplloyeeController;
import com.example.springbootPractice.Service.EmployeeService;
import com.example.springbootPractice.entity.EmployeeEntity;


@WebMvcTest(EmplloyeeController.class)
public class ReadingEmployeeDataGetRequest {
	
	@Autowired
	MockMvc  mockMvc;
	
	@MockBean
	EmployeeService employeeService;
	
	@Test
	public void readDataTest()throws Exception {
		
		EmployeeEntity e= new EmployeeEntity();
		e.setId(1);
		e.setName("Aditi");
		e.setSalary(100000);
		
		EmployeeEntity e2= new EmployeeEntity();
		e2.setId(2);
		e2.setName("Sarthak");
		e2.setSalary(1100);
		
		
				
		List<EmployeeEntity> employees = Arrays.asList(e, e2);
		when(employeeService.readData()).thenReturn(employees);
		
		 mockMvc.perform(get("/employee/readingEmployeeData/")
	                .accept(MediaType.APPLICATION_JSON))//expects the output response in JSON format
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andExpect(content().json("[{\"id\":1,\"name\":\"Aditi\",\"salary\":100000},{\"id\":2,\"name\":\"Sarthak\",\"salary\":1100}]"));//returns the data as json
		
	}
	

}
