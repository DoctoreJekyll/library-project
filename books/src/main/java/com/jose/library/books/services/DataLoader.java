package com.jose.library.books.services;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jose.library.books.model.Books;
import com.jose.library.books.repositories.BooksRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final BooksRepository booksRepository;

    public DataLoader(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(booksRepository.count() == 0) {
            booksRepository.save(new Books(null, "Mistborn", "Brandon Sanderson", 541, 5, "An epic fantasy novel with a unique magic system.", "jose"));
            System.out.println("Dummy books added!");
        }
    }
}

