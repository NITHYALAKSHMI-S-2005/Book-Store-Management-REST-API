package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) { this.service = service; }

    @GetMapping
    public List<Book> getAllBooks() { return service.getAllBooks(); }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) { return service.getBookById(id); }

    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) { return service.createBook(book); }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book book) { return service.updateBook(id, book); }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) { service.deleteBook(id); }
}
