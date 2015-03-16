package cz.carsharing.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User{

    private static final long serialVersionUID = 123321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Department department;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Vehicle> rentVehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Vehicle> getRentVehicles() {
        return rentVehicles;
    }

    public void setRentVehicles(List<Vehicle> rentVehicles) {
        this.rentVehicles = rentVehicles;
    }

    @Override
    public String toString() {
        return firstName +" "+lastName;
    }
}
