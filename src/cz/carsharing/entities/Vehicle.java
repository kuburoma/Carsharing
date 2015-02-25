package cz.carsharing.entities;

import java.io.Serializable;

/**
 * Created by Nell-NTB on 25.2.2015.
 */
public abstract class Vehicle implements Serializable {

    private static final long serialVersionUID = 12345678L;

    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
