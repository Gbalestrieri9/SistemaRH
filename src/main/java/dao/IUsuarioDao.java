package dao;

import exception.SistemaRHDBException;

import java.sql.SQLException;

public interface IUsuarioDao {

    public void criarUsuario(String nome, String email, String senha) throws SistemaRHDBException;
    public int loginUsuario(String email,String senha) throws SistemaRHDBException;

    String getTipoConta(int id) throws SistemaRHDBException;
}
