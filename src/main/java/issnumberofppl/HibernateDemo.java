package issnumberofppl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.LinkedList;

public class HibernateDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(ISSPeople.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        LinkedList<ISSPeople> issPeople = new LinkedList<>();
        ISSPeople issPeople1 = new ISSPeople("Adam Nowak", "ABC");
        ISSPeople issPeople2 = new ISSPeople("Patryk Kowalski", "CBA");
        issPeople.add(issPeople1);
        issPeople.add(issPeople2);



        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (ISSPeople issPeople3 : issPeople) {
            session.save(issPeople3);
        }
        transaction.commit();
        session.close();




    }
}
