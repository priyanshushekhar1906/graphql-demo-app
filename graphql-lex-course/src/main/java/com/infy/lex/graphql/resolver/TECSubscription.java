package com.infy.lex.graphql.resolver;

import java.time.Duration;
import java.util.List;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.infy.lex.graphql.entity.Company;
import com.infy.lex.graphql.service.CompanyService;

import reactor.core.publisher.Flux;

@Controller
public class TECSubscription {

    @Autowired
    private CompanyService companyService;

    @SchemaMapping(typeName="Subscription",field="allCompanies")
    public Publisher<List<Company>> allCompanies(){

        return Flux.interval(Duration.ofSeconds(10)).map(num->companyService.getAllCompanies());
    }

}
