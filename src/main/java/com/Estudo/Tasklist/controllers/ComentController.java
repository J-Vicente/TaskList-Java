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

import com.Estudo.Tasklist.dtos.coment.ComentAllDto;
import com.Estudo.Tasklist.dtos.coment.NewComentDto;
import com.Estudo.Tasklist.services.ComentService;

@RestController
@RequestMapping("projects/{projectId}/tasks/{taskId}/coments")
public class ComentController {

    @Autowired
    private ComentService comentService;

    @GetMapping
    public ResponseEntity<List<ComentAllDto>> getComents(@PathVariable Long taskId, @PathVariable Long projectId) {
        List<ComentAllDto> coments = comentService.findAll(taskId,projectId);
        return ResponseEntity.ok(coments);
    }


    @PostMapping("/newComent")
    public ResponseEntity<ComentAllDto> createComent(@RequestBody NewComentDto dto, @PathVariable Long taskId) {
        ComentAllDto newComent = comentService.create(dto, taskId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComent);
    }
}
