package com.project.proiectspring.controller;

import com.project.proiectspring.dto.CreateAuthorDto;
import com.project.proiectspring.mapper.AuthorMapper;
import com.project.proiectspring.model.Author;
import com.project.proiectspring.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    public List<Author> get(
            @RequestParam(required = false)
            String lastName) {

        return authorService.get(lastName);
    }

    @PostMapping
    public ResponseEntity<Author> create(
            @RequestBody
            @Valid
            CreateAuthorDto createAuthorDto
    ) {
        Author author = authorMapper.createAuthorDtoToAuthor(createAuthorDto);
        Author createdAuthor = authorService.create(author);
        return ResponseEntity.created(URI.create("/authors/" + createdAuthor.getId()))
                .body(createdAuthor);
    }

}