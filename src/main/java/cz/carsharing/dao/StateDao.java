package cz.carsharing.dao;

import cz.carsharing.entities.State;
import cz.carsharing.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;

import java.util.List;

public class StateDao extends GenericDaoImpl<State,Long> {

    public StateDao(){
        super(State.class);
    }

    public List<State> findByName(String findName) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Property name = Property.forName("name");
            Criteria criteria = session.createCriteria(State.class).add(name.eq(findName));
            List<State> objects = criteria.list();
            tx.commit();
            return objects;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            return null;
        }
    }


}
