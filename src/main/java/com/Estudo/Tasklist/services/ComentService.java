package com.Estudo.Tasklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Estudo.Tasklist.dtos.coment.ComentAllDto;
import com.Estudo.Tasklist.dtos.coment.NewComentDto;
import com.Estudo.Tasklist.entities.Coment;
import com.Estudo.Tasklist.entities.Task;
import com.Estudo.Tasklist.entities.User;
import com.Estudo.Tasklist.repositories.ComentRepository;
import com.Estudo.Tasklist.repositories.TaskRepository;
import com.Estudo.Tasklist.repositories.UserRepository;


@Service
public class ComentService {

    @Autowired
    private ComentRepository comentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ComentAllDto> findAll(Long taskId, long projectId) {
        List<ComentAllDto> coments = taskService.findById(taskId, projectId).getComent();
        return coments;
    }


    @Transactional
    public ComentAllDto create(NewComentDto dto, Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrado"));

        User author = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Usuário autor não encontrado"));

        Coment coment = new Coment();
        coment.setDate(dto.getDate());
        coment.setMessage(dto.getMessage());
        coment.setTask(task);
        coment.setAuthor(author);

        Coment newComent = comentRepository.save(coment);

        task.getComent().add(newComent);      

        return new ComentAllDto(newComent);
    }
}
