package com.livelo.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swagger() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.livelo"))
                .paths(PathSelectors.regex("/.*")).build().apiInfo(metaInfo());




    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo("Desafio Projeto Livelo", "API para cadastro de clientes e cidades!! ",
                "Versão Alpha", "Terms",
                new Contact("Desenvolvedor - Alexandre Nardelli - Linkedin - >" ,
                        "https://www.linkedin.com/in/alenardelli", null),
                "Apache License", "https://www.apache.org/licenses/LICENSE-2.0.txt", new ArrayList<>());
        return apiInfo;

    }

}
