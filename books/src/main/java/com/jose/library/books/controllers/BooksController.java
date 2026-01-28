package com.jose.library.books.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.books.dtos.BooksRequest;
import com.jose.library.books.dtos.BooksResponse;
import com.jose.library.books.mappers.BooksMapper;
import com.jose.library.books.model.Books;
import com.jose.library.books.services.BooksServicesImpl;

import java.util.List;

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
    private final BooksMapper booksMapper;

    public BooksController(BooksServicesImpl booksServices, BooksMapper booksMapper) {
        this.booksServices = booksServices;
        this.booksMapper = booksMapper;
    }

    @GetMapping("user/{username}")
    public ResponseEntity<List<BooksResponse>> getBooksByUsername(@PathVariable("username") String username) {
        List<BooksResponse> books = booksServices.getBooksByUsername(username)
        .stream()
        .map(booksMapper::toResponse)
        .toList();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/me")
    public ResponseEntity<List<BooksResponse>> getMyBooks(@RequestHeader("X-Auth-User") String user) {
        List<BooksResponse> books = booksServices.getBooksByUsername(user)
        .stream()
        .map(booksMapper::toResponse)
        .toList();

        return ResponseEntity.ok(books);
    }

    @PostMapping()
    public ResponseEntity<BooksResponse> postMethodName(@RequestBody BooksRequest books, @RequestHeader("X-Auth-User") String user) {
        Books book = booksMapper.toEntity(books,  user);
        Books savedBook = booksServices.createBook(book, user);
        BooksResponse booksResponse = booksMapper.toResponse(savedBook);
        return ResponseEntity.ok(booksResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BooksResponse> updateBooks(@PathVariable Long id, @RequestBody BooksRequest books, @RequestHeader("X-Auth-User") String user) {
        Books book = booksMapper.toEntity(books, user);
        Books updatedBook = booksServices.updateBook(id, book, user);
        BooksResponse booksResponse = booksMapper.toResponse(updatedBook);
        return ResponseEntity.ok(booksResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        booksServices.deleteBook(id, user);
        return ResponseEntity.ok().build();
    }

}
