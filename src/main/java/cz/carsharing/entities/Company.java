package cz.carsharing.entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String motto;


    @OneToMany(mappedBy = "company")
    @Cascade({CascadeType.ALL})
    private List<Department> departments;

    @ManyToOne(fetch = FetchType.EAGER)
    private State state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Transient
    public void addDepartment(Department department) {
        if(this.departments == null){
            this.departments = new ArrayList<Department>();
        }
        this.departments.add(department);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("--- Company ----\n");
        sb.append("Name: "+name+"\n");
        sb.append("Motto: "+motto+"\n");
        sb.append("----------------");
        return sb.toString();
    }
}
