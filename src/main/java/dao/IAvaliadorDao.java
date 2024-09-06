package dao;

import dto.CategoriaEHabilidadeDto;
import exception.SistemaRHDBException;

import java.util.List;

public interface IAvaliadorDao {

    public List<CategoriaEHabilidadeDto> retornaHabilidadesPorEmail(String email) throws SistemaRHDBException;
}
