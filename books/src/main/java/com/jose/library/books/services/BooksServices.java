package com.jose.library.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.books.model.Books;

@Service
public interface BooksServices {
    List<Books> getBooksByUsername(String username);
    Optional<Books> getBookByIdAndUsername(Long id, String username);
    Books createBook(Books book, String username);
    Books updateBook(Long id, Books book, String username);
    void deleteBook(Long id, String username);
}
