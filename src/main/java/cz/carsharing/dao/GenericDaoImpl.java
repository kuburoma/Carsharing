package cz.carsharing.dao;

import cz.carsharing.entities.Carr;
import cz.carsharing.utilities.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Nell on 25.2.2015.
 */
public class GenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK> {

    public GenericDaoImpl(Class entityClass){
        this.entityClass = entityClass;
    }

    private Class entityClass;

    @Override
    public T find(PK id) {


        return null;
    }

    @Override
    public List<T> findAll() {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(entityClass);

        List<T> objects = criteria.list();
        tx.commit();
        return objects;
    }

    @Override
    public PK create(T object) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        PK pk = (PK) session.save(object);
        session.flush();
        tx.commit();
        session.close();
        return pk;
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }
}

