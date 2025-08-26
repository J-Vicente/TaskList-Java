package com.Estudo.Tasklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Estudo.Tasklist.dtos.project.NewProjectDto;
import com.Estudo.Tasklist.dtos.project.ProjectAllDto;
import com.Estudo.Tasklist.dtos.project.ProjectDto;
import com.Estudo.Tasklist.entities.Project;
import com.Estudo.Tasklist.entities.User;
import com.Estudo.Tasklist.repositories.ProjectRepository;
import com.Estudo.Tasklist.repositories.UserRepository;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ProjectAllDto> findAll() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(project -> new ProjectAllDto(project)).toList();
    }

    @Transactional(readOnly = true)
    public ProjectDto findById(Long id) {
        Project result = projectRepository.findById(id).get();    
        return new ProjectDto(result);
    }

    @Transactional
    public Project create(NewProjectDto dto) {
        User creator = userRepository.findById(dto.getCreatorId())
                .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado"));

        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setCreator(creator);

        return projectRepository.save(project);
    }
  
}
