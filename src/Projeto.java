import java.util.ArrayList;
import java.util.List;

class Projeto{
    private String nome;
    private String descricao;
    private String criador;
    private List<Tarefa> tarefas = new ArrayList<>();

    public void Usuario(String nome, String descricao, String criador){
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
    }


    public void adicionarTarefa(Tarefa tarefa){

    }

    public void listarTarefas(){

    }
}