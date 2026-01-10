package com.jose.library.books.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.books.model.Books;
import com.jose.library.books.services.BooksServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksServices booksServices;

    public BooksController(BooksServices booksServices) {
        this.booksServices = booksServices;
    }

    @GetMapping()
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(booksServices.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(booksServices.getBookById(id));
    }

    @PostMapping()
    public ResponseEntity<?> saveBook(@RequestBody Books book) {     
        Books savedBook = booksServices.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Books book) {
        Books updatedBook = booksServices.updateBook(id, book);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        booksServices.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
