package com.hugoamac.ms_spring_postgres.application.service.impl;

import org.springframework.stereotype.Service;

import com.hugoamac.ms_spring_postgres.application.service.TaskService;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.ListTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.usecase.CreateTaskUseCase;
import com.hugoamac.ms_spring_postgres.domain.usecase.ListTaskUseCase;

@Service
public class TaskServiceImpl implements TaskService {

    private final CreateTaskUseCase createTaskUseCase;

    private final ListTaskUseCase listTaskUseCase;

    public TaskServiceImpl(CreateTaskUseCase createTaskUseCase, ListTaskUseCase listTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.listTaskUseCase = listTaskUseCase;
    }

    @Override
    public CreateTaskOutputDTO create(CreateTaskInputDTO createTaskInputDTO) {
        return createTaskUseCase.execute(createTaskInputDTO);
    }

    @Override
    public ListTaskOutputDTO list() {
        return listTaskUseCase.execute();
    }

}
