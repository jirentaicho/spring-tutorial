package com.volkruss.tutorialstudy.caching.repository;

import com.volkruss.tutorialstudy.caching.model.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("TableBookRepository")
public class TableBookRepository implements BookRepository{

    private final Map<String, Book> table = new HashMap<>();

    public TableBookRepository(){
        this.table.put("isbn-1289", new Book("isbn-1289", "WordPressCookBook"));
        this.table.put("isbn-6789",new Book("isbn-6789", "RubyCookBook"));
        this.table.put("isbn-4377",new Book("isbn-4377", "PythonCookBook"));
    }

    @Cacheable("booktable")
    @Override
    public Book findByIsbn(String isbn) {
        this.simulateSlowService();
        return this.table.get(isbn);
    }

    @Override
    @CacheEvict(value = "booktable", allEntries = true)
    public void update(String isbn, String title) {
        this.table.put(isbn,new Book(isbn,title));
    }

    private void simulateSlowService(){
        try{
            Thread.sleep(3000L);
        }catch (InterruptedException e){
            throw new IllegalStateException(e);
        }
    }

}
