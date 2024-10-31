package com.hugoamac.ms_spring_postgres.adapter.controller;

import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskResource taskResource;

    public TaskController(TaskResource taskResource) {
        this.taskResource = taskResource;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateTaskOutputDTO> create(@RequestBody CreateTaskInputDTO input) {
        return taskResource.create(input).join();
    }

    @GetMapping("/list")
    public ResponseEntity<ListTaskOutputDTO> list() {
        return taskResource.list().join();
    }

    @GetMapping("/find/{code}")
    public ResponseEntity<FindTaskOutputDTO> find(@PathVariable("code") String code) {
        return taskResource.find(code).join();
    }
}
