package com.library.service;

import java.util.List;

import com.library.dto.BookDTO;
import com.library.entity.Library;

public interface LibraryService {

	Library getLibraryById(Long id);

	String deleteLibrary(Long id);

	String updateLibrary(Library library);

	String addLibrary(Library library);

	List<Library> getAll();

	List<BookDTO> getBooksByLibraryId(Long libraryId);
}