package com.reactive.app.services;

import com.reactive.app.entities.Book;
import com.reactive.app.repositories.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private BookRepo bookRepo;

    @Test
    public void findMethodTest(){
//        Flux<Book> springBoot = bookRepo.findByName("Spring Boot");
//        StepVerifier.create(springBoot)
//                .expectNextCount(1)
//                .verifyComplete();
//        Flux<Book> guidoVanRossum = bookRepo.findByAuthor("Guido van Rossum");
//        StepVerifier.create(guidoVanRossum)
//                .expectNextCount(1)
//                .verifyComplete();
//        bookRepo.findByNameAndAuthor("Python", "Guido van Rossum")
//                .as(StepVerifier::create)
//                .expectNextCount(1)
//                .verifyComplete();
    }
    @Test
    public void queryMethodTest(){
        bookRepo.findAllBooksByAuthor("Guido van Rossum")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }
}
