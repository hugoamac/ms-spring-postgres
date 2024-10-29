package com.hugoamac.ms_spring_postgres.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private String id;
    private String name;
    private String description;
    private Boolean done;

}
