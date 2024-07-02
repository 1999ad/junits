package com.example.springbootPractice.testing1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springbootPractice.Service.Calculator;

import lombok.extern.log4j.Log4j;
@Log4j
public class Demo1 {

	Calculator calculator;
	
	@BeforeEach//execute before each test case
    public void init() {
		
		calculator = new Calculator();
    }
	
	@Test
	public void testMultiply() {		
		assertEquals(6,calculator.multiply(2, 3));//chk the actual output with expected output
		//assertEquals(9,calculator.multiply(10, 2));//expected ,actual
		
	}

}
