package model;

public class InsumoPerecivel extends Insumo {
    private String dataValidade;

    public InsumoPerecivel(int id, String nome, int quantidade, String dataValidade) {
        super(id, nome, quantidade);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() { return dataValidade; }
    public void setDataValidade(String dataValidade) { this.dataValidade = dataValidade; }

    @Override
    public String toString() {
        return super.toString() + ", Validade: " + dataValidade;
    }
}