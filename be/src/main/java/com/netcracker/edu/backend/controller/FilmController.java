package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Film;
import com.netcracker.edu.backend.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/films")
public class FilmController {

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value="/{id_FILM}", method = RequestMethod.GET)
    public Optional<Film> getFilmById(@PathVariable(name="id_FILM") Long id){
        return filmService.getFilmById(id);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public Iterable<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Film saveFilm(@RequestBody Film film){
        return filmService.saveFilm(film);
    }

    @RequestMapping(value = "/{id_FILM}", method = RequestMethod.DELETE)
    public ResponseEntity deleteFilm(@PathVariable(name="id_FILM") Long id){
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}