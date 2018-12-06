package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.Film;
import com.netcracker.edu.backend.repository.FilmRepository;
import com.netcracker.edu.backend.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FilmServiceImpl implements FilmService {

    private FilmRepository repository;

    @Autowired
    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public Film saveFilm(Film film) {
        return repository.save(film);
    }

    @Override
    public Optional<Film> getFilmById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Film> getAllFilms() {
        return repository.findAll();
    }

    @Override
    public void deleteFilm(Long id) {
        repository.deleteById(id);
    }
}
