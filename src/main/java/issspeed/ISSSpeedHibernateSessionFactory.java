package issspeed;

import issspeed.ISSSpeed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ISSSpeedHibernateSessionFactory {

    public void issSpeedSave(ISSSpeedHibernate issSpeedHibernate, SessionFactory sessionFactory){
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(ISSSpeedHibernate.class);

        sessionFactory = configuration.buildSessionFactory();




        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(issSpeedHibernate);
        transaction.commit();
        session.close();
    }
    

}
