package edu.umanizales.claro.entities.enums;

public enum EnumTipoVendedor {

    LINEA("Linea", 0),
    FISICO("Fisico", 1),
    CALLE("Calle", 2);

    private String valor;
    private int indice;
    EnumTipoVendedor(String valor, int indice) {
        this.valor = valor;
        this.indice = indice;
    }

    public String getValor() {
        return valor;
    }

    public int getIndice() {
        return indice;
    }
}
