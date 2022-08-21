package org.example.dao;

import org.example.model.Director;
import org.example.model.Movie;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MoviesDao {

    private Session session;

    public MoviesDao() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }


    public List<Movie> getMovieByLang(String language) {
        Query query = session.createQuery("from Movie m where m.language=:lang");
        query.setString("lang", language);
        return query.list();
    }

    public List<Movie> getMovieByDirector(String directorId) {
        Query query = session.createQuery("from Movie where director_directorID=:directorID");
        query.setString("directorID", directorId);
        return query.list();
    }

    public void addMovie(Movie movie) {


        session.save(movie);
        session.getTransaction().commit();
    }

    public void updateRevenue(String id, Integer revenue) {
        Query query = session.createQuery("UPDATE Movie  set revenueInDollers = revenueInDollers +" + revenue + " WHERE movieId = :movieId");
        query.setString("movieId", id);
        session.getTransaction().commit();
    }

    public void deleteMovieByName(String movieName) {
        Query query = session.createQuery("delete from Movie where movieName=:name");
        query.setString("name", movieName);

    }

    public List<String> getDistinctLang() {
        Query query = session.createQuery("SELECT DISTINCT(language) FROM Movie");
        return query.getResultList();
    }
}
