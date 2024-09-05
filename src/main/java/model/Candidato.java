package model;

import java.util.List;

public class Candidato extends Usuario{

    private List<Habilidade> habilidades;
    private Status status;

    public Candidato(String nome, String email, String senha, String tipo, List<Habilidade> habilidades, Status status) {
        super(nome, email, senha, tipo);
        this.habilidades = habilidades;
        this.status = status;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
