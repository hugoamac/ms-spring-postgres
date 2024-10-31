package com.hugoamac.ms_spring_postgres.domain.dto;

import java.util.List;

import com.hugoamac.ms_spring_postgres.domain.entity.Task;

/**
 * This record provide the output dto to ListTask Use Case.
 */
public record ListTaskOutputDTO(List<Task> tasks) {}
