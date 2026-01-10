package com.jose.library.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.books.model.Books;

@Service
public interface BooksServices {
    List<Books> getAllBooks();
    Optional<Books> getBookById(Long id);
    Books createBook(Books book);
    Books updateBook(Long id, Books book);
    void deleteBook(Long id);
}
