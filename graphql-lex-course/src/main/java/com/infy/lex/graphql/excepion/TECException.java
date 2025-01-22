package com.infy.lex.graphql.excepion;

@SuppressWarnings("serial")
public class TECException extends RuntimeException{

    // private Map<String,Object> extensions=new HashMap<>();

    public TECException(String message){
         super(message);
    }

    // @Override
    // public List<SourceLocation> getLocations() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    // @Override
    // public ErrorClassification getErrorType() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    // @Override
    // public Map<String,Object> getExtensions(){
    //     return extensions;
    // }

}
