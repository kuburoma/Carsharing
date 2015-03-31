package cz.carsharing.entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String currency;

    @OneToMany(mappedBy = "state")
    @Cascade({CascadeType.ALL})
    private List<Company> companies;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Transient
    public void addCompany(Company company) {
        if(this.companies == null){
            this.companies = new ArrayList<Company>();
        }
        this.companies.add(company);
    }



    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("---- State -----\n");
        sb.append("Name: "+name+"\n");
        sb.append("Currency: "+currency+"\n");
        sb.append("----------------");
        return sb.toString();
    }
}
