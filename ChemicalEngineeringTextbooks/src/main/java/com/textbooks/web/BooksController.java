package com.textbooks.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.textbooks.business.Books;
import com.textbooks.business.BooksRepository;


@Controller
@RequestMapping("/Textbooks") // call user controller
public class BooksController {
	@Autowired
	private BooksRepository textbooksRepository; // variable that calls out CRUD methods
	
	@GetMapping("/List")
	public @ResponseBody Iterable<Books> getAllTextbooks() {
		Iterable<Books> textbooks = textbooksRepository.findAll();
		return textbooks; // return in iterable list of vendors		
	}
	
	@GetMapping("/Get")
	public @ResponseBody Optional<Books> getTextbook(@RequestParam int id) {
		Optional<Books> textbooks = textbooksRepository.findById(id);
		return textbooks; // return in iterable list of vendors		
	}
	
	@PostMapping("/Add")
	public @ResponseBody Books addTextbook(@RequestBody Books textbooks) {
		return textbooksRepository.save(textbooks);
	}
	
	@PostMapping("/Change")
	public @ResponseBody Books updateTextbook(@RequestBody Books textbooks) {
		return textbooksRepository.save(textbooks);
	}
	
	@PostMapping("/Remove")
	public @ResponseBody String removeTextbook(@RequestBody Books textbooks) {
		textbooksRepository.delete(textbooks);
		return "textbooks deleted";
	}
}
