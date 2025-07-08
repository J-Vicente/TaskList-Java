package service;

import java.util.*;
import models.*;

public class GerenciarUsuario{

    static Map<String, Usuario> usuariosSistema = new HashMap<>();
    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

    public static void cadastrarUsuario() {
        System.out.print("Informe o nome do novo usuario: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o email do novo usuario: ");
        String email = scanner.nextLine();
        System.out.print("Informe a senha do novo usuario: ");
        String senha = scanner.nextLine();

        if (usuariosSistema.containsKey(nome)) {
            System.out.println("Usuario ja existe.");
        } else {
            usuariosSistema.put(nome, new Usuario(nome, email, senha));
            System.out.println("Usuario cadastrado com sucesso.");
        }
    }

    public static void fazerLogin() {
        while (usuarioLogado == null) {            
            System.out.print("Informe o nome do usuario: ");
            String nome = scanner.nextLine();
        
            if (usuariosSistema.containsKey(nome)) {
                System.out.print("Informe a senha: ");
                String senha = scanner.nextLine();

                if(usuariosSistema.get(nome).validarSenha(senha)){
                    usuarioLogado = usuariosSistema.get(nome);
                
                    System.out.println("Login efetuado com sucesso: "+usuarioLogado.getNome());
                    menuUsuario();
                } else {
                    System.out.println("Senha incorreta.");
                }
            } else {
                System.out.println("Usuario nao encontrado.");
            }
        }
    }

    public static void menuUsuario() {
        while (true) {
            System.out.println("\n=== Menu do Usuario: " + usuarioLogado.getNome() + " ===");
            System.out.println("1. Cadastrar novo Projeto");
            System.out.println("2. Navegar para um Projeto");
            System.out.println("0. Logout");
            System.out.print("Escolha uma opcao: ");
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
                    System.out.println("Opcao invalida!");
            }
        }
    }
}