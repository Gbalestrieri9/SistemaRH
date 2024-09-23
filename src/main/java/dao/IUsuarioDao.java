package dao;

import exception.SistemaRHDBException;
import model.Usuario;

import java.sql.SQLException;

public interface IUsuarioDao {

    public void criarUsuario(Usuario usuario) throws SistemaRHDBException;
    public int loginUsuario(String email,String senha) throws SistemaRHDBException;

    String getTipoConta(int id) throws SistemaRHDBException;
}
