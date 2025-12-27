package com.booknest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/library/{libraryId}")
    public List<Book> getBooksByLibraryId(@PathVariable Long libraryId) {
        return bookService.getBooksByLibraryId(libraryId);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        restTemplate.getForObject(
                "http://LIBRARYSERVICE/libraryapi/" + book.getLibraryId(),
                Library.class
        );
        return bookService.addBook(book);
    }

    @GetMapping("/{bookId}/library")
    public Library getLibraryOfBook(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        return restTemplate.getForObject(
                "http://LIBRARYSERVICE/libraryapi/" + book.getLibraryId(),
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
