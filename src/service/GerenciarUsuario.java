package service;

import java.util.*;
import models.*;

public class GerenciarUsuario{

    static Map<String, Usuario> usuariosSistema = new HashMap<>();
    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

    public static void cadastrarUsuario() {
        System.out.print("Informe o nome do novo usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o email do novo usuário: ");
        String email = scanner.nextLine();
        System.out.print("Informe a senha do novo usuário: ");
        String senha = scanner.nextLine();

        if (usuariosSistema.containsKey(nome)) {
            System.out.println("Usuário já existe.");
        } else {
            usuariosSistema.put(nome, new Usuario(nome, email, senha));
            System.out.println("Usuário cadastrado com sucesso.");
        }
    }

    public static void fazerLogin() {
        System.out.print("Informe o nome do usuário: ");
        String nome = scanner.nextLine();

        if (usuariosSistema.containsKey(nome)) {
            usuarioLogado = usuariosSistema.get(nome);
            System.out.println("Login efetuado com sucesso.");
            menuUsuario();
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void menuUsuario() {
        while (true) {
            System.out.println("\n=== Menu do Usuário: " + usuarioLogado + " ===");
            System.out.println("1. Cadastrar novo Projeto");
            System.out.println("2. Navegar para um Projeto");
            System.out.println("0. Logout");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    GerenciarProjetos.cadastrarProjeto();
                    break;
                case "2":
                    GerenciarProjetos.navegarParaProjeto();
                    break;
                case "0":
                    usuarioLogado = null;
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}