package dao;

import dto.CategoriaEHabilidadeDto;
import dto.VagaDto;
import exception.SistemaRHDBException;

import java.util.List;

public interface IAvaliadorDao {

    public List<CategoriaEHabilidadeDto> retornaHabilidadesPorEmail(int id,String email) throws SistemaRHDBException;

    public List<VagaDto> listarVagas() throws SistemaRHDBException;

    public void inserirCandidatoVaga(int id, String email,String vagaNumero) throws SistemaRHDBException;
}
