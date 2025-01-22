package com.infy.lex.graphql.entity;

import org.springframework.stereotype.Component;

@Component
public class CompEmp {

    int empId;
    int compId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }



}
