package com.hugoamac.ms_spring_postgres.domain.usecase;

import java.util.UUID;

import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;

/**
 * @author hugo
 * @since 2022-11-16
 * This class provides the use case for creating a task 
 */
public class CreateTaskUseCase {

    private TaskRepository taskRepository;

    public CreateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Execute the use case to created a task
     * @param createTaskInputDTO
     * @return The dto with the id of the created task
     */
    public CreateTaskOutputDTO execute(CreateTaskInputDTO createTaskInputDTO) {

        try {

            UUID uuid = UUID.randomUUID();
            String idString = uuid.toString();

            Task task = new Task();
            task.setId(idString);
            task.setName(createTaskInputDTO.getName());
            task.setDescription(createTaskInputDTO.getDescription());
            task.setDone(false);

            String id = taskRepository.create(task);
            CreateTaskOutputDTO createTaskOutputDTO = new CreateTaskOutputDTO();
            createTaskOutputDTO.setId(id);

            return createTaskOutputDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}