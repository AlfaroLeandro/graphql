package com.vinsguru.graphqlplayground;

import graphql.scalars.ExtendedScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.vinsguru.graphqlplayground.lec12")
public class GraphqlPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlPlaygroundApplication.class, args);
	}

}
