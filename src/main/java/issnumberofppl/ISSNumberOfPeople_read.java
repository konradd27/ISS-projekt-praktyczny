package issnumberofppl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ISSNumberOfPeople_read {
    public List<ISSPeople> getISSPeopleFromSQL() {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(ISSPeople.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();




        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<ISSPeople> list = loadAllData(ISSPeople.class, session);

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
