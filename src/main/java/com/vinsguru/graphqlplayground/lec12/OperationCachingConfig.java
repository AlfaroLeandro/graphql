package com.vinsguru.graphqlplayground.lec12;

import graphql.ExecutionInput;
import graphql.execution.preparsed.PreparsedDocumentEntry;
import graphql.execution.preparsed.PreparsedDocumentProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Configuration
public class OperationCachingConfig {

    @Bean
    public PreparsedDocumentProvider provider() {
        return new PreparsedDocumentProvider() {
            Map<String, PreparsedDocumentEntry> map = new ConcurrentHashMap<>();

            @Override
            public PreparsedDocumentEntry getDocument(ExecutionInput executionInput, Function<ExecutionInput, PreparsedDocumentEntry> parseAndValidateFunction) {
                if(map.containsKey(executionInput.getQuery())) {
                    return map.get(executionInput.getQuery())
                }

                parseAndValidateFunction.apply(executionInput);

                return null;
            }
        }
    }
}
