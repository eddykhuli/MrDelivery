/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author User
 */
@EnableSwagger2
@ComponentScan("com.example.demo.controllers")
@PropertySource("classpath:swagger.properties")
@Configuration// means its a configuration class
public class SwaggerConfig {
    
    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "License";
    private static final String TITLE = " MRDFood RESTful API ";
    private static final String DESCRIPTION = "RESTful API for mrdfood project";
    
    private ApiInfo apiInfo()
    {   
        return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).license(LICENSE_TEXT).version(SWAGGER_API_VERSION).build();
    }
    
    @Bean
    public Docket mrdfoodApi()
    {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select().paths(PathSelectors.regex("/api.*")).build();
    }
    
}
