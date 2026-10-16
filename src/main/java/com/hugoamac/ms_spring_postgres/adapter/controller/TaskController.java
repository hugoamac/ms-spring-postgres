package com.hugoamac.ms_spring_postgres.adapter.controller;

import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugoamac.ms_spring_postgres.application.resource.TaskResource;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.FindTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.ListTaskOutputDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Task", description = "Operações de tarefas")
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskResource taskResource;

    public TaskController(TaskResource taskResource) {
        this.taskResource = taskResource;
    }

    @Operation(summary = "Cria uma tarefa")
    @PostMapping("/create")
    public ResponseEntity<CreateTaskOutputDTO> create(@RequestBody CreateTaskInputDTO input) {
        return taskResource.create(input).join();
    }

    @Operation(summary = "Lista as tarefas")
    @GetMapping("/list")
    public ResponseEntity<ListTaskOutputDTO> list() {
        return taskResource.list().join();
    }

    @Operation(summary = "Busca uma tarefa pelo código")
    @GetMapping("/find/{code}")
    public ResponseEntity<FindTaskOutputDTO> find(@PathVariable("code") String code) {
        return taskResource.find(code).join();
    }
}
