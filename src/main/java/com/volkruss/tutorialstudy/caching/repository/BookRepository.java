package com.volkruss.tutorialstudy.caching.repository;

import com.volkruss.tutorialstudy.caching.model.Book;

public interface BookRepository {
    Book findByIsbn(String isbn);
    void update(String isbn, String title);
}
