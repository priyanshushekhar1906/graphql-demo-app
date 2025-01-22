package com.infy.lex.graphql.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int cid;
    String name;
    String description;

    @OneToMany(mappedBy="company",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    List<Employee> employees=new ArrayList<>();

    public int getcId() {
        return cid;
    }
    public void setcId(int cId) {
        this.cid = cId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    
    


}
