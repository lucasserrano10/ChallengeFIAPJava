package model;

public class Movimento {
//    Movimento seria o ato de pegar ou retirar algo do almoxarifado
    private int idInsumo;
    private int quantidade;
    private String tipo; // ENTRADA ou SAIDA
    private String dataHora;

    public Movimento(int idInsumo, int quantidade, String tipo, String dataHora) {
        this.idInsumo = idInsumo;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public int getIdInsumo() { return idInsumo; }
    public int getQuantidade() { return quantidade; }
    public String getTipo() { return tipo; }
    public String getDataHora() { return dataHora; }

    @Override
    public String toString() {
        return "Movimento: [InsumoID: " + idInsumo + ", Tipo: " + tipo + ", Quantidade: " + quantidade + ", Data: " + dataHora + "]";
    }
}