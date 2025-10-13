package com.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.Book;
import com.library.entity.Library;
import com.library.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;


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
//    @GetMapping("/books/all/{libraryId}")
//    public List<Book> getAllBooksByLibraryId(@PathVariable Long libraryId) {
//        return libraryService.getAllBooksByLibraryId(libraryId);
//    }

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
