package com.project.proiectspring.service;

import com.project.proiectspring.exception.AuthorNotFoundException;
import com.project.proiectspring.model.Author;
import com.project.proiectspring.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(Author author) { return authorRepository.save(author); }

    public Author update(Author author) {
        Optional<Author> existingAuthor = authorRepository.findById(author.getId());
        if (existingAuthor.isEmpty()) {
            throw new AuthorNotFoundException();
        }
        return authorRepository.save(author);
    }

    public List<Author> get(String lastName) {

        List<Author> authors = new ArrayList<>();

        if(lastName != null && !lastName.isEmpty()) {
            authors = authorRepository.findByLastName(lastName);
        } else {
            authors = authorRepository.findAll();
        }
        return authors;
    }
}
