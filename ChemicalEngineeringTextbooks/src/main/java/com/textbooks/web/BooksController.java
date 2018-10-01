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
@RequestMapping("/Books") // call user controller
public class BooksController {
	@Autowired
	private BooksRepository booksRepository; // variable that calls out CRUD methods
	
	@GetMapping("/List")
	public @ResponseBody Iterable<Books> getAllTextbooks() {
		Iterable<Books> books = booksRepository.findAll();
		return books; // return in iterable list of vendors		
	}
	
	@GetMapping("/Get")
	public @ResponseBody Optional<Books> getTextbook(@RequestParam int id) {
		Optional<Books> books = booksRepository.findById(id);
		return books; // return in iterable list of vendors		
	}
	
	@PostMapping("/Add")
	public @ResponseBody Books addTextbook(@RequestBody Books books) {
		return booksRepository.save(books);
	}
	
	@PostMapping("/Change")
	public @ResponseBody Books updateTextbook(@RequestBody Books books) {
		return booksRepository.save(books);
	}
	
	@PostMapping("/Remove")
	public @ResponseBody String removeTextbook(@RequestBody Books books) {
		booksRepository.delete(books);
		return "textbooks deleted";
	}
}
