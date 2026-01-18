package com.booknest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booknest.dto.Library;
import com.booknest.entity.Book;
import com.booknest.repository.BookRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final RestTemplate restTemplate;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepo.findByGenre(genre);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepo.existsById(id)) {
            book.setId(id);
            return bookRepo.save(book);
        }
        return null;
    }

    public List<Book> getBooksByLibraryId(Long libId) {
        return bookRepo.findByLibraryId(libId); 
    }
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

	@Override
	public List<Library> getLibrary() {
		String libraryServiceUrl = "http://LIBRARY/library/getAll";

        Library[] library = restTemplate.getForObject(libraryServiceUrl, Library[].class);

        return library != null ?  Arrays.asList(library) : List.of(); 
	}
}