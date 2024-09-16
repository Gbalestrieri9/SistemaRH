package dao;

import dto.CategoriaEHabilidadeDto;
import dto.VagaDto;
import exception.SistemaRHDBException;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IAvaliadorDao {

    public List<CategoriaEHabilidadeDto> retornaHabilidadesPorEmail(String email) throws SistemaRHDBException;

    public List<VagaDto> listarVagas() throws SistemaRHDBException;

    public boolean inserirCandidatoVaga(int id, String email,String vagaNumero) throws DataAccessException, SistemaRHDBException;
    public String criarAvaliador(String nome, String email, String senha) throws SistemaRHDBException;
}
