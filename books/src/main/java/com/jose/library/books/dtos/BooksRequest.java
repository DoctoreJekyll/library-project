package com.jose.library.books.dtos;

public record BooksRequest(
    String title,
    String author,
    float numberOfPages,
    int rating,
    String review
) {  

}
