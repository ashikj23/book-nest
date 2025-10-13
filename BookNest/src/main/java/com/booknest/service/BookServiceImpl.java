package com.booknest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booknest.entity.Book;
import com.booknest.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

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
        return bookRepo.findByLibraryId(libId); // Fetch books using repository
    }
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }


}
