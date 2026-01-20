package com.jose.library.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.books.model.Books;
import com.jose.library.books.repositories.BooksRepository;

@Service
public class BooksServicesImpl implements BooksServices {

    private final BooksRepository booksRepository;

    public BooksServicesImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    @Override
    public List<Books> getBooksByUsername(String username) {
        List<Books> books = booksRepository.findByUsername(username);
        return books;
    }


    @Override
    public Optional<Books> getBookByIdAndUsername(Long id, String username) {
        Optional<Books> book = booksRepository.findByIdAndUsername(id, username);
        if (book.isPresent()) {
            return book;
        }
        return Optional.empty();
    }


    @Override
    public Books createBook(Books book, String username) {
        book.setUsername(username);
        return booksRepository.save(book);
    }

    
    @Override
    public Books updateBook(Long id, Books book, String username) {
        Books existingBook = booksRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setNumberOfPages(book.getNumberOfPages());
        existingBook.setReview(book.getReview());
        existingBook.setRating(book.getRating());

        return booksRepository.save(existingBook);
    }


    @Override
    public void deleteBook(Long id, String username) {
        Books existingBook = booksRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Book not found"));
        booksRepository.delete(existingBook);
    }

}
