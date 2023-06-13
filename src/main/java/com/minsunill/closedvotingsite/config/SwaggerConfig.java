package com.minsunill.closedvotingsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Response;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EnableWebMvc
@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Closed Voting Site")
                .description("Closed Voting Site API Docs").version("1.0.0").build();
    }

    @Bean
    public Docket swaggerApi() {
        List<Response> messages = Arrays.asList(
                new ResponseBuilder().code(String.valueOf(200)).description("OK").build(),
                new ResponseBuilder().code(String.valueOf(201)).description("Created").build(),
                new ResponseBuilder().code(String.valueOf(202)).description("Accepted").build(),
                new ResponseBuilder().code(String.valueOf(204)).description("No Content").build(),
                new ResponseBuilder().code(String.valueOf(400)).description("Bad Request").build(),
                new ResponseBuilder().code(String.valueOf(401)).description("Unauthorized").build(),
                new ResponseBuilder().code(String.valueOf(404)).description("Not Found").build(),
                new ResponseBuilder().code(String.valueOf(500)).description("Internal Server Error").build()
        );

        // NOTE : http://springfox.github.io/springfox/docs/current/#configuration-explained
        return new Docket(DocumentationType.OAS_30)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.minsunill.closedvotingsite.controller"))    // basePackage 부분에 Swagger를 적용할 패키지 지정
                .paths(PathSelectors.any())
                .build()
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, messages)
                .globalResponses(HttpMethod.POST, messages)
                .globalResponses(HttpMethod.PUT, messages)
                .globalResponses(HttpMethod.PATCH, messages)
                .globalResponses(HttpMethod.DELETE, messages);
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }
}