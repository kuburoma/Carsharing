package cz.carsharing.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.IndexColumn;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "department")
    @Cascade({CascadeType.ALL})
    private List<User> users;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Transient
    public void addUser(User user) {
        if(this.users == null){
            this.users = new ArrayList<User>();
        }
        this.users.add(user);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("-- Department --\n");
        sb.append("Name: "+name+"\n");
        sb.append("Email: "+email+"\n");
        sb.append("----------------");
        return sb.toString();
    }
}
