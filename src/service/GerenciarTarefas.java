package service;

import java.util.*;
import models.*;

public class GerenciarTarefas{

    static Map<Projeto, List<Tarefa>> tarefasProjeto = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void cadastrarTarefa(Projeto projeto, Usuario usuarioLogado) {
        System.out.print("Informe o nome da nova tarefa: ");
        String nomeTarefa = scanner.nextLine();
        System.out.print("Informe uma descircao para a nova tarefa: ");
        String descTarefa = scanner.nextLine();

        if(tarefasProjeto.isEmpty()){
            tarefasProjeto.put(projeto, new ArrayList<>());
        }else{
            tarefasProjeto.get(projeto).add(new Tarefa(nomeTarefa, descTarefa, Status.TO_DO, usuarioLogado));
        }

        System.out.println("Tarefa cadastrada com sucesso.");
    }

    public static void navegarParaTarefa(Projeto projeto) {
        List<Tarefa> tarefas = tarefasProjeto.get(projeto);
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("=== Tarefas do Projeto ===");
        System.out.println("- "+projeto.getDesc());

        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i).getTitulo());
        }

        System.out.print("Escolha uma tarefa pelo número: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        if (escolha >= 1 && escolha <= tarefas.size()) {
            Tarefa tarefaSelecionada = tarefas.get(escolha - 1);
            System.out.println("Você navegou para a tarefa: " + tarefaSelecionada.getTitulo());
            menuTarefa(tarefaSelecionada);
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void menuTarefa(Tarefa tarefa){
        while (true) {
            System.out.println("\n=== Tarefa: " + tarefa.getTitulo() + " ===");
            System.out.println("- "+tarefa.getDesc());
            System.out.println("1. Adiconar comentario");
            System.out.println("2. Ler comentarios");
            System.out.println("3. Mudar status");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    GerenciarComentarios.adicionarComentario(tarefa);
                    break;
                case "2":
                    GerenciarComentarios.lerComentarios(tarefa);
                    break;
                case "3":
                    mudarStatus(tarefa);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void mudarStatus(Tarefa tarefa){
        while (true) {
            System.out.println("\n=== Tarefa: " + tarefa.getTitulo() + " ===");
            System.out.println("-Definir status: ");
            System.out.println("1. Nao iniciada");
            System.out.println("2. Em progresso");
            System.out.println("3. Concluida");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    tarefa.setStatus(Status.TO_DO);
                    break;
                case "2":
                    tarefa.setStatus(Status.DOING);
                    break;
                case "3":
                    tarefa.setStatus(Status.DONE);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
    }
}