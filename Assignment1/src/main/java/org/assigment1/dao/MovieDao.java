package org.assigment1.dao;

import org.assigment1.model.Movie;

public interface MovieDao {

    public String addMovie(Movie movie);

    public String deleteMovie(String movieId);

    public String  updateMovie(Movie movie);

    public String getMoviesDetails(String movieId);
}
