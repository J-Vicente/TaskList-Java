import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Tarefa{
    private String titulo;
    private String descricao;
    private Status status;
    private Usuario responsavel;
    private List<Comentario> comentarios = new ArrayList<>();

    public void Tarefa(String titulo, String descricao, Status status, Usuario responsavel){
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
    }
}


class Comentario{
    private Usuario autor;
    private String mensagem;
    private LocalDate data;

    public void Comentario(Usuario autor, String mensagem, LocalDate data){
        this.autor = autor;
        this.mensagem = mensagem;
        this.data = data;
    }
}

enum Status{
    TODO, DOING, DONE;
}