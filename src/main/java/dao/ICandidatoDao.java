package dao;

import exception.SistemaRHDBException;

public interface ICandidatoDao {

    public void CadastrarHabilidade(String categoria, String habilidade) throws SistemaRHDBException;
}
