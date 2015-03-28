package cz.carsharing.dao;

import cz.carsharing.entities.State;
import cz.carsharing.entities.User;
import cz.carsharing.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao extends GenericDaoImpl<User,Long> {

    public UserDao(){
        super(User.class);
    }

    public List<User> findByState(String name){
        Session session = HibernateUtil.currentSession();
        Criteria c = session.createCriteria(User.class, "u");
        c.createAlias("u.department", "d");
        c.createAlias("d.company", "c");
        c.createAlias("c.state", "s");
        c.add(Restrictions.eq("s.name", name));
        return c.list();
    }

}
