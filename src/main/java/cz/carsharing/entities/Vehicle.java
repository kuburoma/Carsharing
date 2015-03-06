package cz.carsharing.entities;

import cz.carsharing.serializer.GetID;

import java.io.Serializable;

/**
 * Created by Nell-NTB on 25.2.2015.
 */
public abstract class Vehicle implements Serializable, GetID {

    private static final long serialVersionUID = 12345678L;

    protected String id;
    protected String name;
    protected String type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return name +" "+type;
    }
}
