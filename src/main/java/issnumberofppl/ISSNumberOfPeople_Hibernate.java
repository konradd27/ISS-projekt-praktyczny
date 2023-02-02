package issnumberofppl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;

public class ISSNumberOfPeople_Hibernate {

    public void saveISSPeople(ArrayList<ISSPeople> issPeople){
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(ISSPeople.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();




        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (ISSPeople issPeople3 : issPeople) {
            session.save(issPeople3);
        }
        transaction.commit();
        session.close();
    }
}
