package main;

import java.util.*;
import service.*;

public class App{
         
    static Scanner scanner = new Scanner(System.in);
        
    public static void main(String[] args) {
        
         while (true) {
            System.out.println("=== Tela de Boas-Vindas ===");
            System.out.println("1. Cadastrar novo Usuário");
            System.out.println("2. Fazer Login");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    GerenciarUsuario.cadastrarUsuario();
                    break;
                case "2":
                    GerenciarUsuario.fazerLogin();
                    break;
                case "0":
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
