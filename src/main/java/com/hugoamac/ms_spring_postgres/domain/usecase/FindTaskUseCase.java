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

    public FindTaskOutputDTO execute(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        try {
            Task task = taskRepository.find(code);
            if (task == null) {
                throw new RuntimeException("Task not found");
            }
            return new FindTaskOutputDTO(task);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while finding the task", e);
        }
    }

}
