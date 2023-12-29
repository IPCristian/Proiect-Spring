package com.project.proiectspring.controller;

import com.project.proiectspring.dto.CreateGenreDto;
import com.project.proiectspring.mapper.GenreMapper;
import com.project.proiectspring.model.Genre;
import com.project.proiectspring.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;
    private final GenreMapper genreMapper;

    public GenreController(GenreService genreService, GenreMapper genreMapper) {
        this.genreService = genreService;
        this.genreMapper = genreMapper;
    }

    @GetMapping
    public List<Genre> get(
            @RequestParam(required = false)
            String description) {
        return genreService.get(description);
    }

    @PostMapping
    public ResponseEntity<Genre> create(
            @RequestBody
            @Valid
            CreateGenreDto createGenreDto
    ) {
        Genre genre = genreMapper.createGenreDtoToGenre(createGenreDto);
        Genre createdGenre = genreService.create(genre);
        return ResponseEntity.created(URI.create("/genres/" + createdGenre.getId()))
                .body(createdGenre);
    }
}
