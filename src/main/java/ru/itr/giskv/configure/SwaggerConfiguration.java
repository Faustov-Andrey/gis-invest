package ru.itr.giskv.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Настройки SWAGGER
 */
@Configuration
@EnableSwagger2
//Пример URL http://localhost:8096/initializer/v1/swagger-ui.html#  префикс берется из properties
//http://localhost:8081/swagger-ui.html#
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("").
                apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.
                basePackage("ru.itr.gis-invest")).paths(PathSelectors.any()).build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Архив системы").description("").termsOfServiceUrl("").build();
    }

}
