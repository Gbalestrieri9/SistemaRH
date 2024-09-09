package dto;

import org.springframework.cglib.core.Local;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class VagaDto {

    private Date data;
    private String descricao;
    private String numero;
    private String dataStr;


    public VagaDto(Date data, String descricao, String numero) {
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
