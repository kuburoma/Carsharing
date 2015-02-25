package cz.carsharing.entities;

import cz.carsharing.serializer.GetID;

import java.io.Serializable;

public class RentCar implements Serializable, GetID{

    private String id;
    private String user;
    private String car;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
