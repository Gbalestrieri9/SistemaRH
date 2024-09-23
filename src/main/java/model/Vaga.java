package model;

import java.util.Date;

public class Vaga {

    private Date data;
    private String descricao;
    private String numero;
    private String dataStr;


    public Vaga(Date data, String descricao, String numero) {
        this.data = data;
        this.descricao = descricao;
        this.numero = numero;
    }

    public void setDataStr(String dataStr)
    {
        this.dataStr=dataStr;
    }
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return
                "Descricao da vaga: " + descricao +
                        "/ Numero da vaga: " + numero +
                        "/ Data de inscrição: " + dataStr ;
    }

}
