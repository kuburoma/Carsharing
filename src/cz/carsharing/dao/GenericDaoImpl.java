package cz.carsharing.dao;

import cz.carsharing.entities.Car;
import cz.carsharing.serializer.Serializer;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nell on 25.2.2015.
 */
public class GenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK> {

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
        return null;
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }
}

