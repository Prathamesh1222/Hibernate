package org.example;

import org.example.model.Asset;
import org.example.model.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

        Session session = sessionfactory.openSession();
        Transaction t = session.beginTransaction();

        addRecord(session);
        getRecord(session);
        deleteRecord(session);
        updateRecord(session);

        session.getTransaction().commit();
    }

    private static void updateRecord(Session session) {
        Employee employee = session.get(Employee.class, 101);
        employee.setPassword("emp123");
        session.saveOrUpdate(employee);
    }

    private static void deleteRecord(Session session) {
        Employee employee = session.get(Employee.class, 10);
        session.remove(employee);
    }


    private static void addRecord(Session session) {
        Asset asset = new Asset(101, 123, 234, "Machine", 435, "Pune");
        Employee employee = new Employee(100, "Ram", "rm22", asset);
        session.save(asset);
        session.save(employee);

    }

    private static void getRecord(Session session) {
        Asset a1 = session.get(Asset.class, 101);
        System.out.println(a1);

        Asset a2 = session.load(Asset.class, 1010);
        System.out.println(a2);

    }
}
