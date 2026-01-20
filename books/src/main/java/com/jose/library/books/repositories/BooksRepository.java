package com.jose.library.books.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.books.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findByUsername(String username);

    Optional<Books> findByIdAndUsername(Long id, String username);

}
