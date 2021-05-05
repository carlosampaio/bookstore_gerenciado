package com.sampaio.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampaio.bookstore.dto.BookDTO;
import com.sampaio.bookstore.dto.MessageResponseDTO;
import com.sampaio.bookstore.entity.Book;
import com.sampaio.bookstore.exception.BookNotFoundException;
import com.sampaio.bookstore.mapper.BookMapper;
import com.sampaio.bookstore.repository.BookRepository;

@Service
public class BookService {

	
	private BookRepository bookRepository;
	
	
	private final BookMapper bookMapper = BookMapper.INSTANCE;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public MessageResponseDTO create(BookDTO bookDTO) {
		//Book bookToSave = BookDTO.converterDtoToModel(bookDTO);
		//Book bookToSave = bookDTO.converterDtoToModel();
		Book bookToSave = bookMapper.toModeL(bookDTO);
		
		
		Book savedBook = bookRepository.save(bookToSave);
		return MessageResponseDTO
				.builder()
				.message("Livro criado com o ID: " + savedBook.getId())
				.build();
			
	}
/*
	public Book findById(Long id) {
		Optional<Book> optionalBook =  bookRepository.findById(id);
		return optionalBook.get();
	}
*/	
	  public BookDTO findById(Long id) throws BookNotFoundException {
	        Book book = bookRepository.findById(id)
	                .orElseThrow(() -> new BookNotFoundException(id));

	        return bookMapper.toDTO(book);
	    }

	
}
