package service;

import java.util.*;
import models.*;

public class GerenciarProjetos{

    static Map<Usuario, List<Projeto>> projetosUsuario = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void cadastrarProjeto() {
        System.out.print("Informe o nome do novo projeto: ");
        String nomeProjeto = scanner.nextLine();
        System.out.print("Informe uma descricao para o novo projeto: ");
        String descProjeto = scanner.nextLine();

        if(projetosUsuario.isEmpty()){
            projetosUsuario.put(GerenciarUsuario.usuarioLogado, new ArrayList<>());
        }
        projetosUsuario.get(GerenciarUsuario.usuarioLogado).add(new Projeto(nomeProjeto, descProjeto, GerenciarUsuario.usuarioLogado));


        System.out.println("Projeto cadastrado com sucesso.");
    }

    public static void navegarParaProjeto() {
        List<Projeto> projetos = projetosUsuario.get(GerenciarUsuario.usuarioLogado);
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
            return;
        }

        System.out.println("=== Projetos Disponiveis ===");
        for (int i = 0; i < projetos.size(); i++) {
            System.out.println((i + 1) + ". " + projetos.get(i).getNome());
        }

        System.out.print("Escolha um projeto pelo numero: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        if (escolha >= 1 && escolha <= projetos.size()) {
            Projeto projetoSelecionado = projetos.get(escolha - 1);
            menuProjeto(projetoSelecionado, GerenciarUsuario.usuarioLogado);
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    public static void menuProjeto(Projeto projeto, Usuario usuarioLogado) {
        while (true) {
            System.out.println("\n=== Projeto: " + projeto.getNome() + " ===");
            System.out.println("1. Cadastrar nova Tarefa");
            System.out.println("2. Navegar para uma Tarefa");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    GerenciarTarefas.cadastrarTarefa(projeto, GerenciarUsuario.usuarioLogado);
                    break;
                case "2":
                    GerenciarTarefas.navegarParaTarefa(projeto);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
}