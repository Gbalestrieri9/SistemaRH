package service;

import dao.IUsuarioDao;
import dao.impl.UsuarioDaoImpl;
import exception.SistemaRHDBException;

import java.sql.SQLException;

public class UsuarioService {

    private IUsuarioDao usuarioDao;

    public UsuarioService() throws SQLException {
        this.usuarioDao = new UsuarioDaoImpl();
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        try {
            usuarioDao.criarUsuario(nome, email, senha);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
    }

    public int loginUsuario(String email, String senha){
        int id =0;
        try {
           id = usuarioDao.loginUsuario(email, senha);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
        return id;
    }

    public String getTipoConta(int id) {
        try {
            return usuarioDao.getTipoConta(id);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}