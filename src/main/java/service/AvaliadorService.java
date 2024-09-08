package service;

import dao.IAvaliadorDao;
import dao.impl.AvaliadorDaoImpl;
import dto.CategoriaEHabilidadeDto;
import exception.SistemaRHDBException;

import java.sql.SQLException;
import java.util.List;

public class AvaliadorService {

    IAvaliadorDao AvaliadorDao;

    public AvaliadorService() throws SQLException {
        this.AvaliadorDao = new AvaliadorDaoImpl();
    }

    public List<CategoriaEHabilidadeDto> retornaHabilidadesPorEmail(int id,String email) {
        try {
            return AvaliadorDao.retornaHabilidadesPorEmail(id,email);
        } catch (SistemaRHDBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
