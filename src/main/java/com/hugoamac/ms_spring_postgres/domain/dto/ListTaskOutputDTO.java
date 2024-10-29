package com.hugoamac.ms_spring_postgres.domain.dto;

import java.util.List;

import com.hugoamac.ms_spring_postgres.domain.entity.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hugo
 * @since 2022-11-16
 *        This class provides the dto for the list of tasks use case
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListTaskOutputDTO {

    private List<Task> tasks;
}