package org.assigment1.dao;

import org.assigment1.model.Movie;
import org.assigment1.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Objects;

public class MovieDaoImpl implements MovieDao {

    private Session session;

    public MovieDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Override
    public String addMovie(Movie movie) {
        try{
        session.save(movie);
        session.getTransaction().commit();
        }catch (Exception exception){
            return "Something went wrong : "+exception.getMessage();
        }
        return "Added";
    }

    @Override
    public String deleteMovie(String movieId) {

        try{
            Movie movie = session.get(Movie.class, movieId);
            if(Objects.nonNull(movie)){
                session.remove(movie);
                session.getTransaction().commit();

            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return Objects.nonNull(movieId)?"deleted" :"not found";
    }

    @Override
    public String updateMovie(Movie movie) {

        try {
        session.update(movie);
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return "updated : "+movie.toString();
    }

    @Override
    public String getMoviesDetails(String movieId) {
        Movie movie;
       try {
            movie = session.get(Movie.class, movieId);
       }catch (Exception exception){
       return "Something went wrong";
       }
       return Objects.nonNull(movie)?movie.toString():"Not Found";
    }
}
