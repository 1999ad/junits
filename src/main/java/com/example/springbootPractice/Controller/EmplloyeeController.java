package com.example.springbootPractice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootPractice.Service.EmployeeService;
import com.example.springbootPractice.entity.EmployeeEntity;

@RestController
@RequestMapping("employee/")
public class EmplloyeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/hello") //done
	public String hii() {
		return "hello for testing";
	}
	
	//read
	@GetMapping("readingEmployeeData/")//done
	public List<EmployeeEntity> readData() {
		List<EmployeeEntity> emp =employeeService.readData();
		return emp;
		
	}
	
	//read particular data
	@GetMapping("readingEmployeeDataWithId/{id}")
	public String readData(@PathVariable Integer id) {
	     String name =employeeService.readData(id);
		return name;
		
	}
	
	//saving
	@PostMapping("saveEmployeeData")//done
	public ResponseEntity<EmployeeEntity> saveEmployeeData(@RequestBody EmployeeEntity newUser){
		try {
			EmployeeEntity emp =employeeService.saveData(newUser);
			return  new ResponseEntity<>(emp,HttpStatus.OK);
		}
		catch(Exception e){
			return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
	

	//update 
	@PutMapping("updateEmployeeData")
	public ResponseEntity<EmployeeEntity> updateById(@RequestBody EmployeeEntity id){
		EmployeeEntity emp =employeeService.updateData(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
		
	}
	
	
	
	
	  /*@PatchMapping("updateId/{id}") 
	  public ResponseEntity<Object> updateId(@PathVariable int id) throws EmployeeException { 
	  EmployeeEntity emp=employeeService.updateDatawithId(id); 
	  return new ResponseEntity<>(emp,HttpStatus.OK); }*/

}
