package cz.carsharing.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nell on 25.2.2015.
 */
public interface GenericDao<T, PK extends Serializable>  {

    T find(PK id);
    List<T> findAll();
    PK create(T object);
    void update(T object);
    void delete(T object);

}
