package com.example.easynotes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="movies")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movie", unique = true, nullable = false)
    private Integer id;

    @Column(name="name", nullable = false, length = 45)
    private String name;

    @Column(name="score", nullable = false)
    private Double score;

    @Column(name="description", nullable = true, length = 200)
    private String description;

    @Column(name="genre", nullable = true, length = 45)
    private String genre;

    public Movie(){

    }

    public Movie(String name, Double score, String description, String genre) {
        this.name = name;
        this.score = score;
        this.description = description;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
