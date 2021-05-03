package com.sampaio.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sampaio.bookstore.dto.MessageResponseDTO;
import com.sampaio.bookstore.entity.Book;
import com.sampaio.bookstore.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public MessageResponseDTO create(Book book) {
		Book savedBook = bookRepository.save(book);
		return MessageResponseDTO
				.builder()
				.message("Livro criado com o ID: " + savedBook.getId())
				.build();
			
	}
	
	
	
	
	
}
