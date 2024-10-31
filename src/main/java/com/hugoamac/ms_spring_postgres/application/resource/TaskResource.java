package com.hugoamac.ms_spring_postgres.application.resource;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.hugoamac.ms_spring_postgres.application.service.TaskService;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.FindTaskOutputDTO;
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
        return CompletableFuture.supplyAsync(() -> {
            try {
                CreateTaskOutputDTO output = taskService.create(createTaskInputDTO);
                return ResponseEntity.ok(output);
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        });
    }

    public CompletableFuture<ResponseEntity<ListTaskOutputDTO>> list() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(taskService.list()));
    }

    public CompletableFuture<ResponseEntity<FindTaskOutputDTO>> find(String code) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                FindTaskOutputDTO output = taskService.find(code);
                return ResponseEntity.ok(output);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
            }
        });
    }

}
