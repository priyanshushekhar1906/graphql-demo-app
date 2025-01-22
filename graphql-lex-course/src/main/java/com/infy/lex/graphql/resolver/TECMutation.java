package com.infy.lex.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.infy.lex.graphql.entity.CompEmp;
import com.infy.lex.graphql.entity.Company;
import com.infy.lex.graphql.entity.Employee;
import com.infy.lex.graphql.service.EmployeeCompanyMutationService;

@Controller
public class TECMutation {

    @Autowired
    private EmployeeCompanyMutationService employeeCompanyMutationService;


    // Add a new Company
    @SchemaMapping(typeName="Mutation")
    public Company addCompany(@Argument("name") String name,@Argument("description") String description){

        Company company=new Company();
        company.setName(name);
        company.setDescription(description);

        return employeeCompanyMutationService.addCompany(company);

    }

     // Add a new Employee
    @SchemaMapping(typeName="Mutation")
    public Employee addEmployee(@Argument("firstName") String firstName,@Argument("lastName") String lastName,@Argument("jobLevel") int jobLevel){

        Employee employee=new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setJobLevel(jobLevel);


        return employeeCompanyMutationService.addEmployee(employee);

    }

    // Map Employee to Company

    @SchemaMapping(typeName="Mutation",field="mapCompEmp")
    public Employee getMapCompEmp(@Argument("input") CompEmp compEmp){
        int compId=compEmp.getCompId();
        int empId=compEmp.getEmpId();

        return employeeCompanyMutationService.mapEmployee(compId, empId);

    }

        // UnMap Employee to Company

        @SchemaMapping(typeName="Mutation",field="unMapCompEmp")
        public Employee UnMapCompEmp(@Argument("input") CompEmp compEmp){
            int compId=compEmp.getCompId();
            int empId=compEmp.getEmpId();
    
            return employeeCompanyMutationService.unMapEmployee(compId, empId);
    
        }


}
