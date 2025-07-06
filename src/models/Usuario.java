package models;

public class Usuario{
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    private boolean validarSenha(String senha){

        return true;
    }

    public String toString(){
        return "";
    }
}