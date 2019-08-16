package com.restangular.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		// throw new RuntimeException("some error has happened!Contact Support");
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello")
	public String hello() {
		return "hello";
	}
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean("Hello World ," + name);
	}
	
}
