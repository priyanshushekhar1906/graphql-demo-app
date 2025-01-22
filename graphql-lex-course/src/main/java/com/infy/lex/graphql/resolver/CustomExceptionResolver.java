package com.infy.lex.graphql.resolver;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import com.infy.lex.graphql.excepion.TECException;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter{

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env){
        if(ex instanceof TECException){
            return GraphqlErrorBuilder.newError()
            .errorType(ErrorType.DataFetchingException)
            .message(ex.getMessage())
            .path(env.getExecutionStepInfo().getPath())
            .location(env.getField().getSourceLocation())
            .build();
        }
        else{
            return null;
        }
    }

}
