package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Film;

import java.util.Optional;

public interface FilmService {

    Film saveFilm(Film film);
    Optional<Film> getFilmById(Long id);
    Iterable<Film> getAllFilms();
    void deleteFilm(Long id);
}
