package cz.carsharing.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userTable")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToMany
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
