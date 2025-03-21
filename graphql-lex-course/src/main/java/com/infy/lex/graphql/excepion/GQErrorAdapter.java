package com.infy.lex.graphql.excepion;

import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

@SuppressWarnings("serial")
public class GQErrorAdapter  implements GraphQLError{

    private GraphQLError error;

    public GQErrorAdapter(GraphQLError error){
        this.error=error;
    }

    @Override
    public Map<String,Object> getExtensions(){
        return error.getExtensions();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return error.getLocations();
    }

      
    @Override
    public ErrorType getErrorType() {
       return (ErrorType) error.getErrorType();
    }

    @Override
    public List<Object> getPath() {
       return error.getPath();
    }

    @Override
    public Map<String,Object> toSpecification() {
       return error.toSpecification();
    }


    @Override
    public String getMessage() {
     return ((ExceptionWhileDataFetching)error instanceof ExceptionWhileDataFetching)?((ExceptionWhileDataFetching) error)
     .getException().getMessage(): error.getMessage();
    }



}
