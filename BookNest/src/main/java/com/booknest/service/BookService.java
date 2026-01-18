package com.booknest.service;

import java.util.List;

import com.booknest.dto.Library;
import com.booknest.entity.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Long id);

	Book addBook(Book book);

	Book updateBook(Long id, Book book);

	void deleteBook(Long id);

	List<Book> getBooksByLibraryId(Long libId);

	List<Library> getLibrary();
}