package models;
import java.util.ArrayList;
import java.util.List;

public class Tarefa{
    private String titulo;
    private String descricao;
    private Status status;
    private Usuario responsavel;
    private List<Comentario> comentarios = new ArrayList<>();

    public Tarefa(String titulo, String descricao, Status status, Usuario responsavel){
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
    }

    public String getTitulo(){
        return this.titulo;
    }
    
    public String getDesc(){
        return this.descricao;
    }

    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
