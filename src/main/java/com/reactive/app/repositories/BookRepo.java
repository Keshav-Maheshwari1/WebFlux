package com.reactive.app.repositories;

import com.reactive.app.entities.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepo extends R2dbcRepository<Book,Integer> {
    Flux<Book> findByName(String name);
    Flux<Book> findByAuthor(String author);
    Flux<Book> findByPublisher(String publisher);
    Flux<Book> findByNameAndAuthor(String name, String author);
    @Query("select * from book_details where author = :auth")
    Flux<Book> findAllBooksByAuthor(@Param("auth") String author);
}
