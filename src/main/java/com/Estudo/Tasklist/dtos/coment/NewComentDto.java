package com.Estudo.Tasklist.dtos.coment;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.Coment;

public class NewComentDto {

    private String message;
    private LocalDate date;
    private Long taskId;
    private Long authorId;

    public NewComentDto() {
    }

    public NewComentDto(Coment entity) {
        BeanUtils.copyProperties(entity, this);
        this.authorId = entity.getAuthor().getId();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
