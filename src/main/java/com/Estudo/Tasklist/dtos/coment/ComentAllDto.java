package com.Estudo.Tasklist.dtos.coment;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.Coment;

public class ComentAllDto {
    
    private String message;
    private LocalDate date;
    private String author;

    public ComentAllDto() {
    }

    public ComentAllDto(Coment entity) {
        BeanUtils.copyProperties(entity, this);
        this.author = entity.getAuthor().getName();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
