package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {
	@RequestMapping("/") // enables home() method to be called from the web
	@ResponseBody 		 // enable method with JSON data 
	String home() {
		return "Hello, world";
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);

	}

}
