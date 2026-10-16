package com.hugoamac.ms_spring_postgres.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskInputDTO;
import com.hugoamac.ms_spring_postgres.domain.dto.CreateTaskOutputDTO;
import com.hugoamac.ms_spring_postgres.domain.entity.Task;
import com.hugoamac.ms_spring_postgres.domain.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("CreateTaskUseCase")
class CreateTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private CreateTaskUseCase useCase;

    @Test
    @DisplayName("deve criar a tarefa e retornar o id")
    void shouldCreateTaskAndReturnId() {
        when(taskRepository.create(any(Task.class))).thenReturn("id-1");

        CreateTaskOutputDTO output = useCase.execute(new CreateTaskInputDTO("name", "desc"));

        assertEquals("id-1", output.id());
        ArgumentCaptor<Task> captor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository).create(captor.capture());
        Task saved = captor.getValue();
        assertNotNull(saved.getId());
        assertEquals("name", saved.getName());
        assertEquals("desc", saved.getDescription());
        assertFalse(saved.getDone());
    }

    @Test
    @DisplayName("deve falhar quando o input for nulo")
    void shouldFailWhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> useCase.execute(null));
    }

    @Test
    @DisplayName("deve falhar quando o repositório retornar id nulo")
    void shouldFailWhenRepositoryReturnsNullId() {
        when(taskRepository.create(any(Task.class))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> useCase.execute(new CreateTaskInputDTO("n", "d")));
    }
}
