package com.reactive.app.controllers;

import com.reactive.app.entities.Book;
import com.reactive.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    // create
    @PostMapping
    public ResponseEntity<Mono<Book>> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book), HttpStatus.OK);
    }

    // get all books
    @GetMapping
    public ResponseEntity<Flux<Book>> getAll(){
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    // get book by id
    @GetMapping("/{bookId}")
    public ResponseEntity<Mono<Book>> getById(@PathVariable int bookId){
        return new ResponseEntity<>(bookService.get(bookId), HttpStatus.OK);
    }

    // update book by id
    @PutMapping("/{bookId}")
    public ResponseEntity<Mono<Book>> update(@RequestBody Book book,@PathVariable int bookId){
        return new ResponseEntity<>(bookService.update(book, bookId), HttpStatus.OK);
    }

    // delete a book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable int bookId){
        return new ResponseEntity<>(bookService.delete(bookId), HttpStatus.OK);
    }



}
