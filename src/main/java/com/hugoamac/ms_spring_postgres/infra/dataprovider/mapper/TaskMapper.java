package com.hugoamac.ms_spring_postgres.infra.dataprovider.mapper;

import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.infra.dataprovider.entity.TaskEntity;

/**
 * @author hugo
 * @since 2022-11-16
 * This class provides the mapper for tasks
 */
public class TaskMapper {

    /**
     * Convert a domain task to a persistence entity task
     * @param task
     * @return 
     */
    public static TaskEntity toEntity(Task task) {

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setCode(task.getId());
        taskEntity.setName(task.getName());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setDone(task.getDone());
        return taskEntity;
    }

    /**
     * Convert a persistence entity task to a domain task
     * @param taskEntity
     * @return
     */
    public static Task toDomain(TaskEntity taskEntity) {
        Task task = new Task();
        task.setId(taskEntity.getCode());
        task.setName(taskEntity.getName());
        task.setDescription(taskEntity.getDescription());
        task.setDone(taskEntity.getDone());
        return task;
    }   
}
