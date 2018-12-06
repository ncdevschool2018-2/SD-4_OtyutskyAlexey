package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_FILM;
    private String name;
    private Long date_release;
    private String description;
    private Double cost_rent;
    private Double cost_buy;

    public Film() {
    }

    public Film(String name, Long date_release, String description, Double cost_rent, Double cost_buy) {
        this.name = name;
        this.date_release = date_release;
        this.description = description;
        this.cost_rent = cost_rent;
        this.cost_buy = cost_buy;
    }

    public Long getId_FILM() {
        return id_FILM;
    }

    public void setId_FILM(Long id_FILM) {
        this.id_FILM = id_FILM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDate_release() {
        return date_release;
    }

    public void setDate_release(Long date_release) {
        this.date_release = date_release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost_rent() {
        return cost_rent;
    }

    public void setCost_rent(Double cost_rent) {
        this.cost_rent = cost_rent;
    }

    public Double getCost_buy() {
        return cost_buy;
    }

    public void setCost_buy(Double cost_buy) {
        this.cost_buy = cost_buy;
    }
}
