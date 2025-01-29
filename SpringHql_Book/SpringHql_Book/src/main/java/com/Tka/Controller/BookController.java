package com.Tka.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Tka.Entity.Book;
import com.Tka.Service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService service;
	@PostMapping("/BookSaveData")
	public String insertData(@RequestBody Book b) {
		String msg=service.insertData(b);
		return msg;		
	}
	@GetMapping("/BookSingleData/{id}")
	public Book singleData(@PathVariable int id) {
	    Book b=service.singleData(id);
	    return b;
		
	}
	@GetMapping("/BookGetAll")
	public List<Book>getAll(){
		List<Book>list=service.getAll();
		return list;
	}
	@PutMapping("/BookUpdateData/{id}")
	public String updateData(@RequestBody Book b ,@PathVariable int id) {
		String msg=service.updateData(b, id);
		return msg;
	}

}
