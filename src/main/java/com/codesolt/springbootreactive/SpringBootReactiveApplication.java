package com.codesolt.springbootreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
public class SpringBootReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveApplication.class, args);
	}
}
