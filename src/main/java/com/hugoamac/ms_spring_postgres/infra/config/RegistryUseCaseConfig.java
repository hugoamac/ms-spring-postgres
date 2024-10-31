package com.hugoamac.ms_spring_postgres.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;
import com.hugoamac.ms_spring_postgres.domain.usecase.CreateTaskUseCase;
import com.hugoamac.ms_spring_postgres.domain.usecase.FindTaskUseCase;
import com.hugoamac.ms_spring_postgres.domain.usecase.ListTaskUseCase;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the configuration for the use case
 */

@Configuration
public class RegistryUseCaseConfig {

    @Bean
    public CreateTaskUseCase createTaskUseCase(TaskRepository taskRepository) {
        return new CreateTaskUseCase(taskRepository);
    }

    @Bean
    public ListTaskUseCase listTaskUseCase(TaskRepository taskRepository) {
        return new ListTaskUseCase(taskRepository);
    }

    @Bean
    public FindTaskUseCase findTaskUseCase(TaskRepository taskRepository) {
        return new FindTaskUseCase(taskRepository);
    }
}
