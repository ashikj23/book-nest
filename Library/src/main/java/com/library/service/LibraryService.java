package com.library.service;

import java.util.List;

import com.library.dto.Book;
import com.library.entity.Library;

public interface LibraryService {

	Library getLibraryById(Long id);

	String deleteLibrary(Long id);

	String updateLibrary(Library library);

	String addLibrary(Library library);

	List<Library> getAll();

	List<Book> getBooksByLibraryId(Long libraryId);

//	List<Book> getAllBooksByLibraryId(Long libraryId);

}
