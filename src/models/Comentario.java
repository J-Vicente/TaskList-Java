package models;
import java.time.LocalDate;

public class Comentario{
    private Usuario autor;
    private String mensagem;
    private LocalDate data;

    public Comentario(Usuario autor, String mensagem, LocalDate data){
        this.autor = autor;
        this.mensagem = mensagem;
        this.data = data;
    }

    public String getMensagem(){
        return this.mensagem;
    }
}
