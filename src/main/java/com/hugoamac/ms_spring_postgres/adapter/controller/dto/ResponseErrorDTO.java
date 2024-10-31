package com.hugoamac.ms_spring_postgres.adapter.controller.dto;

public record ResponseErrorDTO(
    Integer code,
    String message
) {

}
