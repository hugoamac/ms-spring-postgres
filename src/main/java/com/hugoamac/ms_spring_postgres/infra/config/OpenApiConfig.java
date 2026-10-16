package com.hugoamac.ms_spring_postgres.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the configuration for the OpenAPI
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("ms-spring-postgres API")
                .description("API de gerenciamento de tarefas")
                .version("v1"));
    }
}
