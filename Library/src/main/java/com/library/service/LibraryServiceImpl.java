package com.library.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.dto.Book;
import com.library.entity.Library;
import com.library.repository.LibraryRepo;

@Service
public class LibraryServiceImpl implements LibraryService {

	private final LibraryRepo libraryRepo;
	    private final RestTemplate restTemplate;

		public LibraryServiceImpl(LibraryRepo libraryRepo, RestTemplate restTemplate) {
			this.libraryRepo = libraryRepo;
			this.restTemplate = restTemplate;
		}

   
    public List<Book> getBooksByLibraryId(Long libraryId) {
        String bookServiceUrl = "http://BOOKNEST/books/library/" + libraryId;

        Book[] books = restTemplate.getForObject(bookServiceUrl, Book[].class);

        return books != null ? Arrays.asList(books) : List.of(); 
    }
 
    public Library getLibraryById(Long id) {
        return libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found with ID: " + id));
    }

    public String deleteLibrary(Long id) {
        if (libraryRepo.existsById(id)) {
            libraryRepo.deleteById(id);
            return "Library deleted successfully";
        }
        return "Library not found";
    }

    public String updateLibrary(Library library) {
        if (libraryRepo.existsById(library.getId())) {
            libraryRepo.save(library);
            return "Library updated successfully";
        }
        return "Library not found";
    }

    public String addLibrary(Library library) {
        libraryRepo.save(library);
        return "Library added successfully";
    }

    public List<Library> getAll() {
        return libraryRepo.findAll();
    }
}
