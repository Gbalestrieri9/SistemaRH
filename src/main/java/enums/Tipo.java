package enums;

public enum Tipo {

    AVALIADOR('A',"AVALIADOR"),
    CANDIDATO('C',"CANDIDATO");

    private final char sigla;
    private final String descricao;
    Tipo(char sigla,String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public char getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}
