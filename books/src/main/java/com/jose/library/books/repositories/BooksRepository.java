package com.jose.library.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.books.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

}
