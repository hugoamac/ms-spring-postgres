package com.hugoamac.ms_spring_postgres.domain.usecase;

import java.util.List;

import com.hugoamac.ms_spring_postgres.domain.dto.ListTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the use case for listing tasks
 */
public class ListTaskUseCase {

    private final TaskRepository taskRepository;

    public ListTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ListTaskOutputDTO execute() {

        List<Task> tasks = taskRepository.findAll();

        return new ListTaskOutputDTO(tasks);
    }
}
