package com.vinsguru.graphqlplayground.lec10.config;

import com.vinsguru.graphqlplayground.lec10.dto.FruitDTO;
import graphql.schema.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.ClassNameTypeResolver;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.lang.reflect.Type;

@Configuration
public class TypeResolverConfig {

    @Bean
    public RuntimeWiringConfigurer configurer(TypeResolver resolver) {
        return c -> c.type("product", b -> b.typeResolver(resolver));
    }

    @Bean
    public TypeResolver typeResolver() {
        ClassNameTypeResolver resolver = new ClassNameTypeResolver();
        resolver.addMapping(FruitDTO.class, "Fruit");
        return resolver;
    }
}
