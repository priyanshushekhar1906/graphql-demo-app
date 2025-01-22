package com.infy.lex.graphql.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.lex.graphql.entity.Company;
import com.infy.lex.graphql.entity.Employee;
import com.infy.lex.graphql.excepion.TECException;
import com.infy.lex.graphql.repository.CompanyRepository;
import com.infy.lex.graphql.repository.EmployeeRepository;

@Service
public class EmployeeCompanyMutationService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Company addCompany(Company company){

        return companyRepository.saveAndFlush(company);
    }

    public Employee addEmployee(Employee employee){

        return employeeRepository.saveAndFlush(employee);
    }

    public Employee unMapEmployee(Integer cId,Integer eId){

        if(!this.employeeRepository.existsById(eId))
        {
            throw new TECException("Invalid EmployeeId");
        }
        if(!this.companyRepository.existsById(cId))
        {
            throw  new TECException("Invalid CompanyId");
        }

        Optional<Employee> employeeOptional=this.employeeRepository.findById(eId);

        if(employeeOptional.isPresent()){

            Employee emp=employeeOptional.get();

            if(this.companyRepository.existsById(cId)){

                emp.setCompany(null);
                return this.employeeRepository.saveAndFlush(emp);
            }
        }
            
        return null;
    }

    public Employee mapEmployee(Integer cId,Integer eId){

        if(!this.employeeRepository.existsById(eId))
            throw new TECException("Invalid EmployeeId");
        if(!this.companyRepository.existsById(cId))
            throw  new TECException("Invalid CompanyId");

        Optional<Employee> employeeOptional=this.employeeRepository.findById(eId);


        if(employeeOptional.isPresent()){

              Optional<Company> companyOptional=this.companyRepository.findById(cId);

             if(companyOptional.isPresent()){

                Employee emp=employeeOptional.get();
                emp.setCompany(companyOptional.get());

                return this.employeeRepository.saveAndFlush(emp);
             }   


        }
           
        return null;


    }


}
