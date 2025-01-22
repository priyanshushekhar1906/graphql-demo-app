package com.infy.lex.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.lex.graphql.entity.Company;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface  CompanyRepository extends JpaRepository<Company, Integer> {

}
