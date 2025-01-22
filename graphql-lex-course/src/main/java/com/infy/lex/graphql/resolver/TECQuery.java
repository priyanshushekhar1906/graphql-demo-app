package com.infy.lex.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.infy.lex.graphql.entity.Company;
import com.infy.lex.graphql.entity.Employee;
import com.infy.lex.graphql.service.CompanyService;
import com.infy.lex.graphql.service.EmployeeService;

@Controller
public class TECQuery {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @SchemaMapping(typeName="Query")
    public List<Employee> employees(){
        return employeeService.getAllEmployees();
    }


    @SchemaMapping(typeName="Query",field="companies")
    public List<Company> getAllCompanies(){

        return companyService.getAllCompanies();
    }

    @SchemaMapping(typeName="Query",field="employeeById")
    public Employee getEmployeeById(@Argument("eid") int eId){
        return employeeService.getEmployeeById(eId);

    }

    @SchemaMapping(typeName="Query")
    public Company companyById(@Argument("cid") int cId){
        return companyService.getCompanyById(cId);
    }

    @SchemaMapping(typeName="Query")
    public String getMessage(){
        return employeeService.getMessage();
    }

    @SchemaMapping(typeName="Employee",field="company")
    public Company getCompany(Employee employee){
        return employee.getCompany();
    }

    @SchemaMapping(typeName="Company",field="employees")
    public List<Employee> getEmployee(Company company){
        return company.getEmployees();
    }

}
