package com.netcracker.edu.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmViewModel {
    private long id_FILM;
    private String name;
    private long date_release;
    private String description;
    private double cost_rent;
    private double cost_buy;

    public FilmViewModel() {
    }

    public FilmViewModel(long id_FILM, String name, long date_release, String description, double cost_rent, double cost_buy) {
        this.id_FILM = id_FILM;
        this.name = name;
        this.date_release = date_release;
        this.description = description;
        this.cost_rent = cost_rent;
        this.cost_buy = cost_buy;
    }

    public long getId_FILM() {
        return id_FILM;
    }

    public void setId_FILM(long id_FILM) {
        this.id_FILM = id_FILM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate_release() {
        return date_release;
    }

    public void setDate_release(long date_release) {
        this.date_release = date_release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost_rent() {
        return cost_rent;
    }

    public void setCost_rent(double cost_rent) {
        this.cost_rent = cost_rent;
    }

    public double getCost_buy() {
        return cost_buy;
    }

    public void setCost_buy(double cost_buy) {
        this.cost_buy = cost_buy;
    }
}