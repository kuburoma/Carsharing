package cz.carsharing.entities;

import cz.carsharing.serializer.GetID;

import java.io.Serializable;

public class RentVehicle implements Serializable, GetID{

    private static final long serialVersionUID = 7353214432L;

    private String id;
    private String user;
    private String vehicle;

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

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
