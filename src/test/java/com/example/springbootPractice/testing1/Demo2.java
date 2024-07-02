package com.example.springbootPractice.testing1;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.springbootPractice.Service.DemoService;

public class Demo2 {
	
	@Test
	public void doSomethingTest() {

		//DemoService demoService = Mockito.mock(DemoService.class);
		//when(demoService.doSomething()).thenReturn("hello");
		DemoService demoService = new DemoService();
		String result = demoService.doSomething();
        assert(result.equals("hello"));
        assert(result.equals("helo"));//this will fail
	}
	
	//use of thenReturn()
}
