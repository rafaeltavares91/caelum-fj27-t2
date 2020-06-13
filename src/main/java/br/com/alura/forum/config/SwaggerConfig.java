package br.com.alura.forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.ant;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        Contact contato = new Contact(
                "Rafael Tavares",
                "https://github.com/rafaeltavares91",
                "rafaeltavares91@gmail.com");

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Alura Forum API Documentation")
                .description("Está é a documentação iterativa da Rest API do Fórum da Alura")
                .version("1.0")
                .contact(contato)
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("br.com.alura.forum.controller"))
                .paths(ant("/api/**"))
                .build()
                .apiInfo(apiInfo);
    }

}
