package cz.carsharing.dao;

import cz.carsharing.entities.Car;
import cz.carsharing.entities.User;
import cz.carsharing.entities.Vehicle;
import cz.carsharing.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class UserDao extends GenericDaoImpl<User,Long> {

    public UserDao(){
        super(User.class);
    }

}
