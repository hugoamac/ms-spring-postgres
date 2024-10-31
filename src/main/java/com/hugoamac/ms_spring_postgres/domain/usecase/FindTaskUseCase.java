package com.hugoamac.ms_spring_postgres.domain.usecase;

import com.hugoamac.ms_spring_postgres.domain.dto.FindTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;

/**
 * @author hugo
 * @since 2022-11-16
 * This class provides the use case for finding a task
 */
public class FindTaskUseCase {

    private final TaskRepository taskRepository;

    public FindTaskUseCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public FindTaskOutputDTO execute(String code){
        Task task = taskRepository.find(code);
        return new FindTaskOutputDTO(task);
    }

}
