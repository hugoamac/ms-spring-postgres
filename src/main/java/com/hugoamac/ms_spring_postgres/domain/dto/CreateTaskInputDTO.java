package com.hugoamac.ms_spring_postgres.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskInputDTO {

    private String name;
    private String description;
}
