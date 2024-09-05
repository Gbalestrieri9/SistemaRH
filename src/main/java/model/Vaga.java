package model;

import java.util.Date;
import java.util.List;

public class Vaga {

    private long idVaga;
    private long idCandidato;
    private List<Habilidade> habilidades;
    private Date data;

    public Vaga(long idVaga, long idCandidato, List<Habilidade> habilidades, Date data) {
        this.idVaga = idVaga;
        this.idCandidato = idCandidato;
        this.habilidades = habilidades;
        this.data = data;
    }

    public long getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(long idCandidato) {
        this.idCandidato = idCandidato;
    }

    public long getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(long idVaga) {
        this.idVaga = idVaga;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }
}
