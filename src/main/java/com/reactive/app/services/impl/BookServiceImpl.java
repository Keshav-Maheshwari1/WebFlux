package com.reactive.app.services.impl;

import com.reactive.app.entities.Book;
import com.reactive.app.repositories.BookRepo;
import com.reactive.app.services.BookService;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.connection.ConnectionFactoryUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepo bookRepo;
    @Override
    public Mono<Book> create(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
        return bookRepo.findById(bookId);
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono<Book> oldBook = bookRepo.findById(bookId);
        return oldBook.flatMap(book1 -> {
           book1.setName(book.getName());
           book1.setDescription(book.getDescription());
           book1.setAuthor(book.getAuthor());
           book1.setPublisher(book.getPublisher());
            return bookRepo.save(book1);
        });

    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepo.findById(bookId).flatMap(book -> bookRepo.delete(book));
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }
    @Bean
    public DisposableBean embeddedDatabaseShutdownExecutor(ConnectionFactory connectionFactory) {
        return () -> {
            ConnectionFactoryUtils.getConnection(connectionFactory)
                    .flatMap((connection) -> Mono.from(connection.createStatement("SHUTDOWN").execute()))
                    .block();
        };
    }
}
