package com.hugoamac.ms_spring_postgres.application.service;

import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.ListTaskOutputDTO;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the service for tasks
 */
public interface TaskService {

    /**
     * Create a new task
     * 
     * @param createTaskOutputDTO
     * @return
     */
    public CreateTaskOutputDTO create(CreateTaskInputDTO createTaskInputDTO);

    /**
     * List all tasks
     * 
     * @return
     */
    public ListTaskOutputDTO list();
}
