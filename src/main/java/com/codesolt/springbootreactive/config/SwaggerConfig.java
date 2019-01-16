package com.codesolt.springbootreactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("Codesolt - Employee API")
                .apiInfo(apiInfo())
                .enable(true)
                .select().paths(PathSelectors.any())
                .build();             
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Codesolt Cryptocurrency API")
                .description("REST API for determine Cryptocurrency relevance. Consumes BITSO API")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Carlos Salazar", "https://codesolt.com/", "carlos.salazar@codesolt.com"))
                .build();
    }
}