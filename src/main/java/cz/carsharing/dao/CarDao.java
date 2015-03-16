package cz.carsharing.dao;

import cz.carsharing.entities.Car;

import java.util.List;

public class CarDao extends GenericDaoImpl<Car,Long> {

    public CarDao(){
        super(Car.class);
    }



}
