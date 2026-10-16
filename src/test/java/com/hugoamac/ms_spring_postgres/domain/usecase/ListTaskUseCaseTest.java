package com.hugoamac.ms_spring_postgres.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("ListTaskUseCase")
class ListTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private ListTaskUseCase useCase;

    @Test
    @DisplayName("deve listar todas as tarefas")
    void shouldListAllTasks() {
        List<Task> tasks = List.of(new Task("1", "a", "b", false));
        when(taskRepository.findAll()).thenReturn(tasks);

        assertEquals(tasks, useCase.execute().tasks());
    }
}
