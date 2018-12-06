package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.model.FilmViewModel;

import java.util.List;

public interface FilmDataService {
    List<FilmViewModel> getAll();
    FilmViewModel getFilmById(Long id);
    FilmViewModel saveFilm(FilmViewModel account);
    void deleteFilm(Long id);
}
