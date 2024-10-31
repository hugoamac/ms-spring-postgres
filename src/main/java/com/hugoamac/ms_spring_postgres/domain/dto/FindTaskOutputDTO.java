package com.hugoamac.ms_spring_postgres.domain.dto;

import com.hugoamac.ms_spring_postgres.domain.entity.Task;

/**
 * This record provide the input dto to FindTask Use Case.
 */
public record FindTaskOutputDTO(
    Task task
) {

}
