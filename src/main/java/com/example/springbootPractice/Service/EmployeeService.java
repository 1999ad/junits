package com.example.springbootPractice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootPractice.Repository.EmployeeRepository;
import com.example.springbootPractice.entity.EmployeeEntity;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
 
	
	public EmployeeEntity saveData(EmployeeEntity newUser) {
		EmployeeEntity e=new EmployeeEntity();
		e.setId(newUser.getId());
		e.setName(newUser.getName());
		e.setSalary(newUser.getSalary());
		empRepo.save(e);
		return e;
		
	}
	

	public List<EmployeeEntity> readData() {
		List<EmployeeEntity> e=empRepo.findAll();
		return e;
		
	}
	
	public String readData(Integer i) {
		Optional<EmployeeEntity> e=empRepo.findById(i);
		String name=null;
		if(e.isPresent()) {
			name= e.get().getName();
		}
		else {
			name="no data found";
		}
		return name;
		
	}

	public EmployeeEntity updateData(EmployeeEntity newUser) {
		EmployeeEntity e1=new EmployeeEntity();
		Optional<EmployeeEntity> e=empRepo.findById(newUser.getId());
		if(e.isPresent()) {
			e1.setId(1);
			e1.setName("Aditi Gupta");
			e1.setSalary(90000);
			empRepo.save(e1);
			
		}
		
		return e1;
		
	}

}
