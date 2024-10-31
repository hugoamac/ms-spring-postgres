import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.hugoamac.ms_spring_postgres.MsSpringPostgresApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MsSpringPostgresApplication.class)
@AutoConfigureMockMvc
public class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateTask() throws Exception {
        String json = "{\"name\":\"Tarefa 1\",\"description\":\"Descrição da tarefa 1\"}";
        mockMvc.perform(post("/api/v1/task/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldListTasks() throws Exception {
        mockMvc.perform(get("/api/v1/task/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldNotFindTask() throws Exception {
        mockMvc.perform(get("/api/v1/task/find/942d7bc1-6752-44e3-acc0-37da91956851"))
                .andExpect(status().isNotFound());
    }
}