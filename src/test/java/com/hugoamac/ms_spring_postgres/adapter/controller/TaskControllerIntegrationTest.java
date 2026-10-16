package com.hugoamac.ms_spring_postgres.adapter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.hugoamac.ms_spring_postgres.MsSpringPostgresApplication;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest(classes = MsSpringPostgresApplication.class)
@AutoConfigureMockMvc
@DisplayName("TaskController (integração) - /api/v1/task")
class TaskControllerIntegrationTest {

    private static final String BASE_URL = "/api/v1/task";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @DisplayName("deve criar uma tarefa")
    void shouldCreateTask() throws Exception {
        String json = "{\"name\":\"Tarefa 1\",\"description\":\"Descrição da tarefa 1\"}";

        String createdId = null;
        try {
            MvcResult result = mockMvc.perform(post(BASE_URL + "/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").isNotEmpty())
                    .andReturn();

            createdId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
        } finally {
            // the controller runs on another thread, so @Transactional rollback would not apply
            if (createdId != null) {
                taskRepository.delete(createdId);
            }
        }
    }

    @Test
    @DisplayName("deve listar as tarefas")
    void shouldListTasks() throws Exception {
        mockMvc.perform(get(BASE_URL + "/list"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("deve retornar 404 ao buscar tarefa inexistente")
    void shouldNotFindTask() throws Exception {
        mockMvc.perform(get(BASE_URL + "/find/942d7bc1-6752-44e3-acc0-37da91956851"))
                .andExpect(status().isNotFound());
    }
}
