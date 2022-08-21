package org.assignment2;

import org.assignment2.model.Customer;
import org.assignment2.model.Locker;
import org.assignment2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        Customer customer = Customer.builder().customerId(7001)
                .customerName("willem")
                .customerAddress("kolkata")
                .customerDob(new Date(1997 - 07 - 07))
                .locker(new Locker("LOC101","small", 1100))
                .build();

        session.save(customer);
        session.getTransaction().commit();

        System.out.println(session.get(Customer.class,7001));
    }
}
