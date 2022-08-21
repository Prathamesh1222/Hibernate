package org.example;

import org.example.dao.MoviesDao;
import org.example.model.Director;
import org.example.model.Movie;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Movie m = new Movie();
        m.setMovieId("M101");
        m.setMovieName("Home Alone");
        m.setLanguage("English");
        m.setReleasedIn(2022);
        m.setRevenueInDollers(20000);
        m.setDirector(new Director("D101", "chirs", 1990));

        MoviesDao moviesDao=new MoviesDao();

        moviesDao.addMovie(m);

        moviesDao.getMovieByLang("English");

        moviesDao.getMovieByDirector("D101");

        moviesDao.deleteMovieByName("Abc");

        moviesDao.getDistinctLang();

        moviesDao.updateRevenue("M101",10000);



    }
}
