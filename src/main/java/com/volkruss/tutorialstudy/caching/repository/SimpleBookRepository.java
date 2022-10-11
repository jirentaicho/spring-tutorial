package com.volkruss.tutorialstudy.caching.repository;

import com.volkruss.tutorialstudy.caching.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("SimpleBookRepository")
public class SimpleBookRepository implements BookRepository{

    @Override
    @Cacheable("book")
    public Book findByIsbn(String isbn) {
        this.simulateSlowService();
        return new Book(isbn, "Splatoon Strategy");
    }

    @Override
    public void update(String isbn, String title) {
    }

    private void simulateSlowService(){
        try{
            Thread.sleep(3000L);
        }catch (InterruptedException e){
            throw new IllegalStateException(e);
        }
    }
}
