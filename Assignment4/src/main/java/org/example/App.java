package org.example;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

        Session session = sessionfactory.openSession();
        Transaction t = session.beginTransaction();

        Query query1 = session.createQuery("SELECT MAX(revenueInDollars) FROM Movie");
        System.out.println("max "+query1.list());
        //Min
        Query query2 = session.createQuery("SELECT MIN(revenueInDollars) FROM Movie");
        System.out.println("MIN "+query2.list());

        //Sum
        Query query3 = session.createQuery("SELECT SUM(revenueInDollars) FROM Movie");
        System.out.println("Sum "+query3.list());

        //AVG
        Query query4 = session.createQuery("SELECT AVG(revenueInDollars) FROM Movie");
        System.out.println("Avg "+query4.list());

        //COUNT
        String language = "English";
        Query query5 = session.createQuery("SELECT COUNT(*) FROM Movie where language=:lan");
        query5.setString("lan", language);
        System.out.println("count:  "+query5.list());

        //Group By
        Query query6 = session.createQuery("SELECT COUNT(*) FROM Movie m GROUP BY m.language");
        System.out.println("Group by :"+query6.list());
    }
}
