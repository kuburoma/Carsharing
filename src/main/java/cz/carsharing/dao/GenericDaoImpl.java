package cz.carsharing.dao;

import cz.carsharing.entities.Car;
import cz.carsharing.serializer.Serializer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nell on 25.2.2015.
 */
public class GenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK> {

    private static final SessionFactory ourSessionFactory;
    private static final org.hibernate.service.ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    @Override
    public T find(PK id) {


        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public PK create(T object) {
        final Session session = getSession();
        Transaction tx = null;

        tx = session.beginTransaction();
        PK pk = (PK) session.save(object);
        session.flush();
        tx.commit();
        return pk;
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }
}

