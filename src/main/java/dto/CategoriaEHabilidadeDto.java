package dto;

public class CategoriaEHabilidadeDto {

    private String categoria;
    private String habilidades;

    public CategoriaEHabilidadeDto(String categoria, String habilidades) {
        this.categoria = categoria;
        this.habilidades = habilidades;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return
                "categoria: " + categoria +
                ", habilidades: " + habilidades ;
    }
}
