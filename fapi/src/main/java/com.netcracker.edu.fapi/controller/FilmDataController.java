package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.model.FilmViewModel;
import com.netcracker.edu.fapi.service.FilmDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmDataController {

    @Autowired
    private FilmDataService filmDataService;

    @RequestMapping
    public ResponseEntity<List<FilmViewModel>> getAllFilms() {
        return ResponseEntity.ok(filmDataService.getAll());
    }

    @RequestMapping(value = "/{id_FILM}", method = RequestMethod.GET)
    public ResponseEntity<FilmViewModel> getFilmById(@PathVariable("id_FILM") String id) {
        return ResponseEntity.ok(filmDataService.getFilmById(Long.valueOf(id)));
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FilmViewModel> saveFilm(@RequestBody FilmViewModel film /*todo server validation*/) {
        if (film != null) {
            return ResponseEntity.ok(filmDataService.saveFilm(film));
        }
        return null;
    }

    @RequestMapping(value = "/{id_FILM}", method = RequestMethod.DELETE)
    public void deleteFilm(@PathVariable String id) {
        filmDataService.deleteFilm(Long.valueOf(id));
    }
}