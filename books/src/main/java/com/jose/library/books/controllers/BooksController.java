package com.jose.library.books.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.books.model.Books;
import com.jose.library.books.services.BooksServicesImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksServicesImpl booksServices;

    public BooksController(BooksServicesImpl booksServices) {
        this.booksServices = booksServices;
    }

    @GetMapping("user/{username}")
    public ResponseEntity<?> getBooksByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(booksServices.getBooksByUsername(username));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyBooks(@RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(booksServices.getBooksByUsername(user));
    }

    @PostMapping()
    public ResponseEntity<?> postMethodName(@RequestBody Books books, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(booksServices.createBook(books, user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooks(@PathVariable Long id, @RequestBody Books books, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(booksServices.updateBook(id, books, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        booksServices.deleteBook(id, user);
        return ResponseEntity.ok().build();
    }

}
