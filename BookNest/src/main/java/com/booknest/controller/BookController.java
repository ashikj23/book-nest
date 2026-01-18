package com.booknest.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.booknest.dto.Library;
import com.booknest.entity.Book;
import com.booknest.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final RestTemplate restTemplate;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/by-library/{libraryId}")
    public List<Book> getBooksByLibraryId(@PathVariable Long libraryId) {
        return bookService.getBooksByLibraryId(libraryId);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
    	 try {
    	        restTemplate.getForObject(
    	            "http://LIBRARY/libraries/" + book.getLibraryId(),
    	            Library.class
    	        );
    	    } catch (RestClientException ex) {
    	        throw new ResponseStatusException(
    	            HttpStatus.NOT_FOUND,
    	            "Library with id " + book.getLibraryId() + " not found"
    	        );
    	    }
        return bookService.addBook(book);
    }

    @GetMapping("/{id}/library")
    public Library getLibraryOfBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return restTemplate.getForObject(
                "http://LIBRARY/libraries/" + book.getLibraryId(),
                Library.class
        );
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}