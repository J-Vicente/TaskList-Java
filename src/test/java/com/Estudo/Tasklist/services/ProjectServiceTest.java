package com.Estudo.Tasklist.services;


import com.Estudo.Tasklist.dtos.project.NewProjectDto;
import com.Estudo.Tasklist.entities.Project;
import com.Estudo.Tasklist.entities.User;
import com.Estudo.Tasklist.exceptions.ResourceNotFoundException;
import com.Estudo.Tasklist.repositories.ProjectRepository;
import com.Estudo.Tasklist.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ProjectServiceTest {
    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectService projectService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(projectService).build();
    }

    @Test
    @DisplayName("Deve retornar uma RessourceNotFoundException")
    public void NewProject(){
        NewProjectDto projectDto = new NewProjectDto();
        projectDto.setName("Teste");
        projectDto.setDescription("Projeto com criador invalido");
        projectDto.setCreatorId(5);

        Assertions.assertThrows(
            ResourceNotFoundException.class, () -> {projectService.create(projectDto);}
        );
    }
}
