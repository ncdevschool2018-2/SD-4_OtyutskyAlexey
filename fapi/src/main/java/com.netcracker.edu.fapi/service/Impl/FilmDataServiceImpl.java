package com.netcracker.edu.fapi.service.Impl;

import com.netcracker.edu.fapi.model.FilmViewModel;
import com.netcracker.edu.fapi.service.FilmDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FilmDataServiceImpl implements FilmDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<FilmViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        FilmViewModel[] FilmViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/films/", FilmViewModel[].class);
        return FilmViewModelResponse == null ? Collections.emptyList() : Arrays.asList(FilmViewModelResponse);
    }

    @Override
    public FilmViewModel getFilmById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FilmViewModel FilmViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/films/" + Long.toString(id), FilmViewModel.class);
        return FilmViewModelResponse;
    }

    @Override
    public FilmViewModel saveFilm(FilmViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/films", account, FilmViewModel.class).getBody();
    }

    @Override
    public void deleteFilm(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/films/" + id);
    }
}