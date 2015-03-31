package cz.carsharing.entities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userTable")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
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

    @Transient
    public void addRentVehicle(Vehicle rentVehicle) {
        if(this.rentVehicles == null){
            this.rentVehicles = new ArrayList<Vehicle>();
        }
        this.rentVehicles.add(rentVehicle);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("----- User -----\n");
        sb.append("firstName: "+firstName+"\n");
        sb.append("lastName: "+lastName+"\n");
        sb.append("----------------");
        return sb.toString();
    }
}
