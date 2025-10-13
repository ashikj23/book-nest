package com.booknest.service;

import java.util.List;

import com.booknest.entity.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Long id);

	List<Book> getBooksByGenre(String genre);

	List<Book> getBooksByTitle(String title);

	List<Book> getBooksByAuthor(String author);

	Book addBook(Book book);

	Book updateBook(Long id, Book book);

	void deleteBook(Long id);

	List<Book> getBooksByLibraryId(Long libId);

}
