package com.hugoamac.ms_spring_postgres.infra.dataprovider.reposiory.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;
import com.hugoamac.ms_spring_postgres.infra.dataprovider.mapper.TaskMapper;
import com.hugoamac.ms_spring_postgres.infra.dataprovider.reposiory.JpaTaskRepository;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the implementation of the repository for tasks
 */
@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final JpaTaskRepository jpaTaskRepository;

    public TaskRepositoryImpl(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public String create(Task task) {
        return jpaTaskRepository.save(TaskMapper.toEntity(task)).getCode();
    }

    @Override
    public Task find(String id) {
        return jpaTaskRepository.findByCode(id)
                .map(TaskMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public Boolean update(Task task) {
        return jpaTaskRepository.findByCode(task.getId())
                .map(entity -> {
                    entity.setName(task.getName());
                    entity.setDescription(task.getDescription());
                    entity.setDone(task.getDone());
                    return jpaTaskRepository.save(entity) != null;
                })
                .orElse(false);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(TaskMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean delete(String id) {
        return jpaTaskRepository.findByCode(id)
                .map(entity -> {
                    jpaTaskRepository.delete(entity);
                    return true;
                })
                .orElse(false);
    }

}
