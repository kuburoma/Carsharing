package cz.carsharing.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck extends Vehicle {

    private static final long serialVersionUID = 1233214432L;

    private int numberOfWheels;

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("---- Truck -----\n");
        sb.append("Name: "+name+"\n");
        sb.append("Type: "+type+"\n");
        sb.append("wheels: "+numberOfWheels+"\n");
        sb.append("----------------");
        return sb.toString();
    }
}
