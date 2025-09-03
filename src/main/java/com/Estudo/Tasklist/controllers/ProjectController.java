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
import com.Estudo.Tasklist.dtos.responses.ApiResponse;
import com.Estudo.Tasklist.services.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectAllDto>>> getProjects() {
        List<ProjectAllDto> projects = projectService.findAll();

        ApiResponse<List<ProjectAllDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(projects);
        response.setMessage("Requisição completada com sucesso");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectDto>> getProjectById(@PathVariable Long id) {
        ProjectDto project = projectService.findById(id);

        ApiResponse<ProjectDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(project);
        response.setMessage("Requisição completada com sucesso");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/newProject")
    public ResponseEntity<ApiResponse<ProjectDto>> createProject(@Valid @RequestBody NewProjectDto dto) {
        ProjectDto newProject = projectService.create(dto);

        ApiResponse<ProjectDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(newProject);
        response.setMessage("Projeto criado com sucesso");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
