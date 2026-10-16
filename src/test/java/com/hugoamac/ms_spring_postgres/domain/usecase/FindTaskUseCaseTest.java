package com.hugoamac.ms_spring_postgres.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hugoamac.ms_spring_postgres.domain.dto.FindTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("FindTaskUseCase")
class FindTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private FindTaskUseCase useCase;

    @Test
    @DisplayName("deve retornar a tarefa encontrada")
    void shouldReturnTask() {
        Task task = new Task("1", "name", "desc", false);
        when(taskRepository.find("1")).thenReturn(task);

        FindTaskOutputDTO output = useCase.execute("1");

        assertSame(task, output.task());
    }

    @Test
    @DisplayName("deve falhar quando o código for nulo ou vazio")
    void shouldFailWhenCodeIsNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> useCase.execute(null));
        assertThrows(IllegalArgumentException.class, () -> useCase.execute(""));
    }

    @Test
    @DisplayName("deve falhar quando a tarefa não for encontrada")
    void shouldFailWhenTaskNotFound() {
        when(taskRepository.find("x")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> useCase.execute("x"));
    }
}
