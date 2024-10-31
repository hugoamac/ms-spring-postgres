package com.hugoamac.ms_spring_postgres.domain.usecase;

import java.util.UUID;

import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the use case for creating a task
 */
public class CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public CreateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Execute the use case to created a task
     * 
     * @param createTaskInputDTO
     * @return The dto with the id of the created task
     */
    public CreateTaskOutputDTO execute(CreateTaskInputDTO createTaskInputDTO) {

        if (createTaskInputDTO == null) {
            throw new IllegalArgumentException("CreateTaskInputDTO cannot be null");
        }

        try {

            UUID uuid = UUID.randomUUID();
            String idString = uuid.toString();

            Task task = new Task();
            task.setId(idString);
            task.setName(createTaskInputDTO.name());
            task.setDescription(createTaskInputDTO.description());
            task.setDone(false);

            String id = taskRepository.create(task);

            if (id == null) {
                throw new RuntimeException("An error occurred while creating the task");
            }

            return new CreateTaskOutputDTO(id);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while creating the task", e);
        }
    }
}