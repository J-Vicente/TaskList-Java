package com.Estudo.Tasklist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estudo.Tasklist.dtos.project.NewProjectDto;
import com.Estudo.Tasklist.dtos.project.ProjectAllDto;
import com.Estudo.Tasklist.dtos.project.ProjectDto;
import com.Estudo.Tasklist.entities.Project;
import com.Estudo.Tasklist.services.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectAllDto>> getProjects() {
        List<ProjectAllDto> projects = projectService.findAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id) {
        ProjectDto project = projectService.findById(id);
        return ResponseEntity.ok(project);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody NewProjectDto dto) {
        Project newProject = projectService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
    }

}
