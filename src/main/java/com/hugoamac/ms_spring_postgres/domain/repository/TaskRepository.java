package com.hugoamac.ms_spring_postgres.domain.repository;

import java.util.List;

import com.hugoamac.ms_spring_postgres.domain.entity.Task;

/**
 * @author hugo
 * @since 2022-11-16
 * This class provides the interface to the repository for tasks
 * 
 */
public interface TaskRepository {

    /**
     * Create a new task
     * @param task
     * @return The id of the created task
     */
    public String create(Task task);

    /**
     * Find a task
     * @param id
     * @return The task
     */
    public Task find(String id);

    /**
     * Update a task
     * @param task
     * @return The updated task
     */
    public Boolean update(Task task);

    /**
     * Find all tasks
     * @return The list of tasks
     */
    public List<Task> findAll();

    /**
     * Delete a task
     * @param id
     * @return True if the task was deleted
     */
    public Boolean delete(String id);
}
