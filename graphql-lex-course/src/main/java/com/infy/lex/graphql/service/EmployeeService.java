package com.infy.lex.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.lex.graphql.entity.Employee;
import com.infy.lex.graphql.excepion.TECException;
import com.infy.lex.graphql.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private String message="Simple Employee Schema!";

    public Employee getEmployeeById(int eId){

        Employee employee=null;

        Optional<Employee> employeeOptional=employeeRepository.findById(eId);
        if(employeeOptional.isPresent())
            employee=employeeOptional.get();
        else    
            throw  new TECException("No such Employee with id:"+eId+" exists");   
        return employee;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public String getMessage(){
        return message;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
