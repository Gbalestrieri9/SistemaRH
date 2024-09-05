package dao;

import exception.SistemaRHDBException;

import java.sql.SQLException;

public interface IUsuarioDao {

    public void criarUsuario(String nome, String email, String senha, String tipo) throws SistemaRHDBException;
    public long loginUsuario(String email,String senha) throws SistemaRHDBException;
}
