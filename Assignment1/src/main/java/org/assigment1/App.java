package org.assigment1;

import org.assigment1.dao.MovieDaoImpl;
import org.assigment1.model.Movie;
import org.assigment1.util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {

      //  add();

 getMovie();

    //  update();

      //  delete();
    }
    public static void add(){
        System.out.println(new MovieDaoImpl().addMovie(new Movie("MOVIE-1", "Thor", "English", 2022, 90000)));
    }

    public static void delete(){
        System.out.println(new MovieDaoImpl().deleteMovie("MOVIE-1"));
    }

    public static void getMovie(){
        System.out.println(new MovieDaoImpl().getMoviesDetails("MOVIE-1"));
    }
    public static void update(){
        System.out.println(new MovieDaoImpl().updateMovie(new Movie("MOVIE-1", "MoneyHeist", "English", 2018, 90000)));

    }
}
