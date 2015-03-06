package cz.carsharing.entities;


import javax.persistence.*;

@Entity
@Table(name = "carrit")
public class Carr  {

    private Long id;
    private String name;
    private String type;


    public Carr() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
