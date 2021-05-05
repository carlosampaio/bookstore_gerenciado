package com.sampaio.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sampaio.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
