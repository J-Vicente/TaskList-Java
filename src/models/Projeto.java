package models;

import java.util.ArrayList;
import java.util.List;

public class Projeto{
    private String nome;
    private String descricao;
    private Usuario criador;
    private List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome, String descricao, Usuario criador){
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDesc(){
        return this.descricao;
    }

    public void adicionarTarefa(Tarefa tarefa){

    }

    public void listarTarefas(){

    }
}