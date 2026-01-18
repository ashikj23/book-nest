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
import org.springframework.web.client.RestTemplate;
import com.library.dto.BookDTO;
import com.library.entity.Library;
import com.library.service.LibraryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/libraries")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;
    private final RestTemplate restTemplate;

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAll();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id);
    }

    @PostMapping
    public String addLibrary(@RequestBody Library library) {
        return libraryService.addLibrary(library);
    }

    @PutMapping("/{id}")
    public String updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        library.setId(id);
        return libraryService.updateLibrary(library);
    }

    @DeleteMapping("/{id}")
    public String deleteLibrary(@PathVariable Long id) {
        return libraryService.deleteLibrary(id);
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        String bookNestUrl = "http://BOOKNEST/books";
        BookDTO[] books = restTemplate.getForObject(bookNestUrl, BookDTO[].class);
        return List.of(books);
    }

 
}