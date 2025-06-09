package model;

public class Usuario {
    private String nome;
    private String cargo;
    private String cpf;

    public Usuario(String nome, String cargo, String cpf) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public String getCargo() { return cargo; }

    public String getCpf() {
        return cpf;
    }

    public void login() {
        System.out.println("Usuário " + nome + " logado como " + cargo + ", com CPF de número " + cpf);
    }
}