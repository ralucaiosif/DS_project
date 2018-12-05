package com.example.easynotes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="user_movies")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class UserMoviesList {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "entry_id", unique = true, nullable = false)
   private Integer entryId;

    @Column(name="user_id", nullable = false)
    private Integer userId;


    @Column(name="movie_id", nullable = false)
    private Integer movieId;

    public UserMoviesList(){}


    public UserMoviesList(Integer userId, Integer movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
