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

import com.Estudo.Tasklist.dtos.responses.ApiResponse;
import com.Estudo.Tasklist.dtos.task.NewTaskDto;
import com.Estudo.Tasklist.dtos.task.TaskAllDto;
import com.Estudo.Tasklist.dtos.task.TaskDto;
import com.Estudo.Tasklist.services.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("projects/{projectId}/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TaskAllDto>>> getTasks(@PathVariable Long projectId) {
        List<TaskAllDto> tasks = taskService.findAll(projectId);

        ApiResponse<List<TaskAllDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(tasks);
        response.setMessage("Requisição completada com sucesso");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskDto>> getTaskById(@PathVariable Long id, @PathVariable Long projectId) {
        TaskDto task = taskService.findById(projectId, id);
        
        ApiResponse<TaskDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(task);
        response.setMessage("Requisição completada com sucesso");

        return ResponseEntity.ok(response);

    }

    @PostMapping("/newTask")
    public ResponseEntity<ApiResponse<TaskDto>> createTask(@Valid @RequestBody NewTaskDto dto, @PathVariable Long projectId) {
        TaskDto newTask = taskService.create(dto, projectId);

        ApiResponse<TaskDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(newTask);
        response.setMessage("Tarefa criada com sucesso");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
