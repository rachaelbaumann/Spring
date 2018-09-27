package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo") // localhost:8080/demo
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/add") // localhost:8080/demo/add       @ResponseBody converts output to JSON
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {//localhost:8080/demo/add?name=&email=
		User u = new User(); // pass instance of an entity
		u.setName(name);
		u.setEmail(email);
		userRepository.save(u);
		return "Saved";
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
		
}
