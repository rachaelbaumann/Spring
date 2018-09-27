package com.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // make it a controller
public class GreetingController {
	
	@GetMapping("/greeting") // specific to get requests, not post requests (RequestMapping)
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") 
										 								String name, Model model) {// method signature
		model.addAttribute("name", name);
		return "greeting";
	}
}
