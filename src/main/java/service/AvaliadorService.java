package service;

import dao.IAvaliadorDao;
import dao.IUsuarioDao;
import dao.impl.AvaliadorDaoImpl;
import dao.impl.UsuarioDaoImpl;
import exception.SistemaRHDBException;

import java.sql.SQLException;

public class AvaliadorService {

    IAvaliadorDao AvaliadorDao;

    public AvaliadorService() throws SQLException {
        this.AvaliadorDao = new AvaliadorDaoImpl();
    }

    public void retornaHabilidadesPorEmail(String email) {
        try {
            AvaliadorDao.retornaHabilidadesPorEmail(email);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
    }
}
