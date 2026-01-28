package com.jose.library.books.dtos;

public record BooksResponse(
    Long id,
    String title,
    String author,
    float numberOfPages,
    int rating,
    String review
) {
}