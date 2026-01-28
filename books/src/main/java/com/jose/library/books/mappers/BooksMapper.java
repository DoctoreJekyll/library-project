package com.jose.library.books.mappers;

import com.jose.library.books.dtos.BooksRequest;
import com.jose.library.books.dtos.BooksResponse;
import com.jose.library.books.model.Books;

public class BooksMapper {

    public Books toEntity(BooksRequest dto, String username) {
        Books book = new Books();
        book.setTitle(dto.title());
        book.setAuthor(dto.author());
        book.setNumberOfPages(dto.numberOfPages());
        book.setRating(dto.rating());
        book.setReview(dto.review());
        book.setUsername(username);
        return book;
    }

    public BooksResponse toResponse(Books book) {
        return new BooksResponse(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getNumberOfPages(),
            book.getRating(),
            book.getReview()
        );
    }

}
