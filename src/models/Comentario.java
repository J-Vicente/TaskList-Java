package models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Comentario{
    private Usuario autor;
    private String mensagem;
    private String data;

    

    public Comentario(Usuario autor, String mensagem, LocalDate data){
        this.autor = autor;
        this.mensagem = mensagem;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormat = data.format(formatter);

        this.data = dataFormat;
    }

    public String getMensagem(){
        return this.mensagem;
    }

    public String getData(){
        return this.data;
    }
}
