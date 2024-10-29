package com.hugoamac.ms_spring_postgres.application.resource;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hugoamac.ms_spring_postgres.application.service.TaskService;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.ListTaskOutputDTO;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the resource for tasks
 */
@Component
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create a new task with a CompletableFuture
     * 
     * @param createTaskInputDTO
     * @return
     */
    public CompletableFuture<ResponseEntity<CreateTaskOutputDTO>> create(CreateTaskInputDTO createTaskInputDTO) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(taskService.create(createTaskInputDTO)));
    }

    public CompletableFuture<ResponseEntity<ListTaskOutputDTO>> list() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(taskService.list()));
    }

}
