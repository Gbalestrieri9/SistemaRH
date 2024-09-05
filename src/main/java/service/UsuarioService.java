package service;

import dao.IUsuarioDao;
import dao.impl.UsuarioDaoImpl;
import exception.SistemaRHDBException;

import java.sql.SQLException;

public class UsuarioService {

    IUsuarioDao usuarioDao;

    public UsuarioService() throws SQLException {
        this.usuarioDao = new UsuarioDaoImpl();
    }

    public void cadastrarUsuario(String nome, String email, String senha, String tipo) {
        try {
            usuarioDao.criarUsuario(nome, email, senha, tipo);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
    }

    public long loginUsuario(String email, String senha){
        long id =0;
        try {
           id = usuarioDao.loginUsuario(email, senha);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
        return id;
    }

}