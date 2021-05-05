package com.sampaio.bookstore.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sampaio.bookstore.entity.Author;
import com.sampaio.bookstore.entity.Book;

import lombok.Data;

@Data
public class BookDTO {

	private Long id;

	@NotBlank
	@Size(max = 200)
	private String name;

	@NotNull
	private Integer pages;

	@NotNull
	private Integer chapters;

	@NotBlank
	@Size(max = 20)
	private String isbn;

	@NotBlank
	@Size(max = 200)
	private String publishName;

	@NotNull
	@Valid
	private Author author;
	
	public Book converterDtoToModel() {
		//Book book = new Book();
		return Book.builder()
		.id(this.id)
		.name(this.name)
		.pages(this.pages)
		.chapters(this.chapters)
		.isbn(this.isbn)
		.publishName(this.publishName)
		.author(this.author)
		.build();
		//.author.setName(dto.getAuthor().getName());
		//.author().setAge(dto.getAuthor().getAge());
		//System.out.println(book.getAuthor().getName());
		
	//	return book;
	}
	

}

/*
	public static Book converterDtoToModel(BookDTO dto) {
		//Book book = new Book();
		return Book.builder()
		.id(dto.getId())
		.name(dto.getName())
		.pages(dto.getPages())
		.chapters(dto.getChapters())
		.isbn(dto.getIsbn())
		.publishName(dto.getPublishName())
		.author(dto.getAuthor())
		.build();
		//.author.setName(dto.getAuthor().getName());
		//.author().setAge(dto.getAuthor().getAge());
		//System.out.println(book.getAuthor().getName());
		
	//	return book;
	}
	

*/
