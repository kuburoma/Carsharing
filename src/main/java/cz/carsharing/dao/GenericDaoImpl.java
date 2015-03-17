package cz.carsharing.dao;

import cz.carsharing.entities.State;
import cz.carsharing.utilities.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Property;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Nell on 25.2.2015.
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    public GenericDaoImpl(Class entityClass) {
        this.entityClass = entityClass;
    }

    private Class entityClass;

    @Override
    public T find(PK id) {
        Session session = HibernateUtil.currentSession();
        try {
            T object = (T) session.get(entityClass, id);
            return object;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        Session session = HibernateUtil.currentSession();
        Criteria criteria = session.createCriteria(entityClass);
        List<T> objects = criteria.list();
        return objects;
    }

    public List<T> findBy(String columnName, String name) {
        Session session = HibernateUtil.currentSession();
        Property column = Property.forName(columnName);
        Criteria criteria = session.createCriteria(entityClass).add(column.eq(name));
        List<T> objects = criteria.list();
        return objects;
    }

    @Override
    public PK create(T object) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            PK pk = (PK) session.save(object);
            tx.commit();
            return pk;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(T object) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(object);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PK id) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            T object = (T) session.get(entityClass, id);
            session.delete(object);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
    }


}

