package cz.carsharing.entities;

import java.io.Serializable;

/**
 * Created by Nell-NTB on 25.2.2015.
 */
public class Car extends Vehicle implements Serializable {

    private static final long serialVersionUID = 12332122L;

    @Override
    public String toString() {
        return name +" "+type;
    }
}
