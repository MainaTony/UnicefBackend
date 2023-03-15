package com.pinnoserv.portal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author mwendwakelvin
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public Docket api() {
        boolean swaggerswitch = environment.getRequiredProperty("datasource.apigateway.swaggerEnable") != null
                && environment.getRequiredProperty("datasource.apigateway.swaggerEnable").equals("true");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pinnoserv.portal.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .apiInfo(apiInfo()).enable(swaggerswitch);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User Microservice Switch")
                .description("User microservice REST API")
                .version("v1.0.0")
                .termsOfServiceUrl("Terms of service")
                .build();
    }
}
