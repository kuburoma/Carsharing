package cz.carsharing.entities;

import cz.carsharing.serializer.GetID;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable, GetID{

    private static final long serialVersionUID = 123321L;

    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName +" "+lastName;
    }
}
