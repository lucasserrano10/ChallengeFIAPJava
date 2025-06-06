package model;

public class Usuario {
    private String nome;
    private String cargo;

    public Usuario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getNome() { return nome; }
    public String getCargo() { return cargo; }

    public void login() {
        System.out.println("Usuário " + nome + " logado como " + cargo);
    }
}