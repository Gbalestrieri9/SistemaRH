package model;

public class Habilidade {

    private String categoria;
    private String habilidade;

    public Habilidade(String categoria, String habilidade) {
        this.categoria = categoria;
        this.habilidade = habilidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
}
