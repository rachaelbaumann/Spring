package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {
	@RequestMapping("hi") // enables home() method to be called from the web
	@ResponseBody 		 // enable method with JSON data 	
	String home(@RequestParam String name) {
		if (name != null && !name.equals("")) 
			return "Hello " + name + "!";
		else
			return "Hello";
	}//http://localhost:8080/hi?name=Katya
	
	@RequestMapping("logon")
	@ResponseBody
	String logon (@RequestParam String username, @RequestParam String password) {
		
		return "Logon attempted: username = " + username + " and password = " + password;
	} //http://localhost:8080/logon?username=Katya&password=mom

	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);

	}

}
