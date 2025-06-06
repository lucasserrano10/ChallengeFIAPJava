package model;

public class ProdutoQuimico extends Insumo {
    private int nivelToxicidade;

    public ProdutoQuimico(int id, String nome, int quantidade, int nivelToxicidade) {
        super(id, nome, quantidade);
        this.nivelToxicidade = nivelToxicidade;
    }

    public int getNivelToxicidade() { return nivelToxicidade; }
    public void setNivelToxicidade(int nivelToxicidade) { this.nivelToxicidade = nivelToxicidade; }

    @Override
    public String toString() {
        return super.toString() + ", Toxicidade: " + nivelToxicidade;
    }
}
