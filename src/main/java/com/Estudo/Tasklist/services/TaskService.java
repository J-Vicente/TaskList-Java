package com.Estudo.Tasklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Estudo.Tasklist.dtos.task.NewTaskDto;
import com.Estudo.Tasklist.dtos.task.TaskAllDto;
import com.Estudo.Tasklist.dtos.task.TaskDto;
import com.Estudo.Tasklist.entities.Project;
import com.Estudo.Tasklist.entities.Task;
import com.Estudo.Tasklist.entities.User;
import com.Estudo.Tasklist.repositories.ProjectRepository;
import com.Estudo.Tasklist.repositories.TaskRepository;
import com.Estudo.Tasklist.repositories.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<TaskAllDto> findAll(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        List<Task> tasks = project.getTasks();
        
        return tasks.stream().map(task -> new TaskAllDto(task)).toList();
    }

    @Transactional(readOnly = true)
    public TaskDto findById(Long projectId, Long id) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        List<Task> tasks = project.getTasks();

        Task result = tasks.stream().filter(task -> task.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));    

        return new TaskDto(result);
    }

    @Transactional
    public TaskDto create(NewTaskDto dto, Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Task task = new Task();
        task.setName(dto.getName());
        task.setTerm(dto.getTerm());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setProject(project);

        List<User> responsibles = userRepository.findAllById(dto.getResponsiblesIds());
        task.setResponsibles(responsibles);

        Task newTask = taskRepository.save(task);

        project.getTasks().add(newTask);

        TaskDto newTaskDto = new TaskDto(newTask);

        return newTaskDto;
    }
}
