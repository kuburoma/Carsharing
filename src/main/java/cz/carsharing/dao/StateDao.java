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
        return this.findBy("name", findName);
    }

    public List<State> findByCurrency(String findCurrency) {
        return this.findBy("currency", findCurrency);
    }


}
