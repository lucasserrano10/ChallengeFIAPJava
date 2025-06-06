package model;

public class Insumo {
    private int id;
    private String nome;
    private int quantidade;

    public Insumo(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public void adicionarQuantidade(int qtd) {
        this.quantidade += qtd;
    }

    public void removerQuantidade(int qtd) {
        this.quantidade -= qtd;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Nome: " + nome + ", Quantidade: " + quantidade + "]";
    }
}