package com.infy.lex.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.lex.graphql.entity.Company;
import com.infy.lex.graphql.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    public Company getCompanyById(int cId){
        
        Optional<Company> optionalCompany=companyRepository.findById(cId);

        return optionalCompany.get();
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }


}
