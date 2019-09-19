package com.allali84.spring.exception;

import com.allali84.usescase.exception.QuestionAlreadyExistsException;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionAlreadyExistsGraphqlException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();


    public QuestionAlreadyExistsGraphqlException(QuestionAlreadyExistsException e, String question) {
        super(e.getMessage());
        extensions.put("QuestionAlreadyExist", question);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

}
