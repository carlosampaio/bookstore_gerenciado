package com.sampaio.bookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampaio.bookstore.dto.BookDTO;
import com.sampaio.bookstore.dto.MessageResponseDTO;
import com.sampaio.bookstore.entity.Book;
import com.sampaio.bookstore.exception.BookNotFoundException;
import com.sampaio.bookstore.service.BookService;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

	
	
	private BookService bookService;
	
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}



	@PostMapping
	public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
			return	bookService.create(bookDTO);
	}
	
	
    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }
	
	/*
	@GetMapping("/{id}")
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
		Book book = bookService.findById(id);
		System.out.println(book.getName());
		System.out.println(book.getAuthor().getName());
		
		return  ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> buscar(@PathVariable("id") Long id) {
		Book book = bookService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	*/
	
}
