package com.example.easynotes.services;

import com.example.easynotes.entities.Movie;
import com.example.easynotes.entities.UserMoviesList;
import com.example.easynotes.repositories.MovieRepository;
import com.example.easynotes.repositories.UserMoviesListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserMoviesListService {

    @Autowired
    private UserMoviesListRepository userMoviesListRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getUserMovies(int userId) {
        List<UserMoviesList> userMovieList = userMoviesListRepository.findAllByUserId(userId);
        List<Integer> movieIds = new ArrayList<>();
        for (UserMoviesList element : userMovieList) {
            movieIds.add(element.getMovieId());
        }
        List<Movie> movies = new ArrayList<>();
        for (Integer id : movieIds) {
            movies.add(movieRepository.findById((int) id));
        }
        return movies;
    }

    public List<Movie> getSuggestedMovies(int userId) {
        List<Movie> userMovies = getUserMovies(userId);
        Double avgScore = getMoviesAvgScore(userMovies);
        String mostLikedGenre = getMostLikedGenres(userMovies);

        System.out.println("avg score: " + avgScore);
        System.out.println("most liked genre of movies: " + mostLikedGenre);
        //get movies by score and genre
        List<Movie> suggestedMovies = movieRepository.findAllByGenreAndScoreBetween(
                mostLikedGenre, avgScore - 1, avgScore + 1);
        return suggestedMovies;
    }



    private String getMostLikedGenres(List<Movie> userMovies) {
        HashMap<String, Integer> genreCount = new HashMap<>();
        for (Movie movie : userMovies) {
            String movieGenre = movie.getGenre();
            if (genreCount.containsKey(movieGenre)) {
                Integer currentValue = genreCount.get(movieGenre);
                currentValue++;
                genreCount.replace(movieGenre, currentValue);
            } else {
                genreCount.put(movieGenre, 1);
            }
        }

        //return the most liked genre of movies
        int max = 0;
        String genre = null;
        for (String s : genreCount.keySet()) {
            int value = genreCount.get(s);
            if (value > max) {
                max = value;
                genre = s;
            }
        }
        return genre;
    }

    private Double getMoviesAvgScore(List<Movie> userMovies) {
        Double avgScore = 0.0;
        for (Movie movie : userMovies) {
            avgScore += movie.getScore();
        }
        avgScore /= userMovies.size();
        return avgScore;
    }

}
