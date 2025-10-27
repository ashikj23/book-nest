package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.library.dto.Book;
import com.library.entity.Library;
import com.library.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    private RestTemplate restTemplate;
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/getAll")
    public List<Library> getAllLibraries() {
        return libraryService.getAll();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id);
    }

    @GetMapping("/all-books-from-booknest")
    public List<Book> getAllBooksFromBookNest() {
        String bookNestUrl = "http://BOOKNEST/books";
        Book[] books = restTemplate.getForObject(bookNestUrl, Book[].class);
        return List.of(books);
    }
    @GetMapping("/books/{libraryId}")
    public List<Book> getBooksByLibraryId(@PathVariable Long libraryId) {
        return libraryService.getBooksByLibraryId(libraryId);
    }
    @PostMapping("/add")
    public String addLibrary(@RequestBody Library library) {
        return libraryService.addLibrary(library);
    }

    @PutMapping("/update/{id}")
    public String updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        library.setId(id); // Ensure the ID is set
        return libraryService.updateLibrary(library);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLibrary(@PathVariable Long id) {
        return libraryService.deleteLibrary(id);
    }
}
