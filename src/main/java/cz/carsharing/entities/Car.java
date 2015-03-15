package cz.carsharing.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car extends Vehicle implements Serializable {

    private static final long serialVersionUID = 12332122L;

    private int numberOfDoors;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return name +" "+type+" "+ numberOfDoors;
    }
}
