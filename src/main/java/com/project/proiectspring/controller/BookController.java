package com.project.proiectspring.controller;

import com.project.proiectspring.dto.CreateBookDto;
import com.project.proiectspring.mapper.BookMapper;
import com.project.proiectspring.model.Author;
import com.project.proiectspring.model.Book;
import com.project.proiectspring.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<Book> get(
            @RequestParam(required = false)
            Author author) {

        return bookService.get(author);
    }

    @PostMapping
    public ResponseEntity<Book> create(
            @RequestBody
            @Valid
            CreateBookDto createBookDto
    ) {
        Book book  = bookMapper.createBookDtoToBook(createBookDto);
        Book createdBook = bookService.create(book);
        return ResponseEntity.created(URI.create("/books/" + createdBook.getId()))
                .body(createdBook);
    }
}
