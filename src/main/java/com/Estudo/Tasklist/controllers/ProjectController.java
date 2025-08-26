package com.Estudo.Tasklist.controllers;

import java.util.List;

import com.Estudo.Tasklist.dtos.project.NewProjectDto;
import com.Estudo.Tasklist.dtos.project.ProjectAllDto;
import com.Estudo.Tasklist.dtos.project.ProjectDto;
import com.Estudo.Tasklist.services.ProjectService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectAllDto> getProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping
    public void createProject(@RequestBody NewProjectDto dto) {
        projectService.create(dto);
    }

}
