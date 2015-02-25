package cz.carsharing.entities;

import java.io.Serializable;

public class UserCar implements Serializable{

    private User user;
    private Car car;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
