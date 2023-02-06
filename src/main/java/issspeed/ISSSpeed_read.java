package issspeed;

import issnumberofppl.ISSPeople;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ISSSpeed_read {
    public List<ISSSpeedHibernate> getISSSpeedFromSQL() {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(ISSSpeedHibernate.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();




        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<ISSSpeedHibernate> list = loadAllData(ISSSpeedHibernate.class, session);

        transaction.commit();
        session.close();
        return list;
    }
    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }
}
