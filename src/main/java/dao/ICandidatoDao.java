package dao;

import exception.SistemaRHDBException;

public interface ICandidatoDao {

    public void CadastrarHabilidade(int idUsuario,String categoria, String habilidade) throws SistemaRHDBException;
}
