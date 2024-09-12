package dao;

import exception.SistemaRHDBException;

public interface ICandidatoDao {

    public String CadastrarHabilidade(int idUsuario,String categoria, String habilidade) throws SistemaRHDBException;
}
