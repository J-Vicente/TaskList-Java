package service;

import java.time.LocalDate;
import java.util.*;
import models.*;

public class GerenciarComentarios{

    static Map<Tarefa, List<Comentario>> comentariosTarefa= new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void adicionarComentario(Tarefa tarefa){
        System.out.println("Digite um comentario para essa tarefa: ");
        String mensagem = scanner.nextLine();

        LocalDate data = LocalDate.now();
        
        if(comentariosTarefa.isEmpty()){
            comentariosTarefa.put(tarefa, new ArrayList<>());
        }else{
            comentariosTarefa.get(tarefa).add(new Comentario(GerenciarUsuario.usuarioLogado, mensagem, data));
        }

        System.out.println("Comentario adicionado.");
    }

    public static void lerComentarios(Tarefa tarefa){
        List<Comentario> comentarios = comentariosTarefa.get(tarefa);
        if (comentarios.isEmpty()) {
            System.out.println("Nenhum comentario cadastrada.");
            return;
        }

        System.out.println("=== Comentarios na tarefa ===");
        System.out.println("- "+tarefa.getDesc());

        for (int i = 0; i < comentarios.size(); i++) {
            System.out.println((i + 1) + ". " + comentarios.get(i).getMensagem());
        }
    }
}