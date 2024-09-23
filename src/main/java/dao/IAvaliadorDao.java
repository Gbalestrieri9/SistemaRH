package dao;

import model.CategoriaEHabilidade;
import model.Usuario;
import model.Vaga;
import exception.SistemaRHDBException;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IAvaliadorDao {

    public List<CategoriaEHabilidade> retornaHabilidadesPorEmail(String email) throws SistemaRHDBException;

    public List<Vaga> listarVagas() throws SistemaRHDBException;

    public boolean inserirCandidatoVaga(int id, String email,String vagaNumero) throws DataAccessException, SistemaRHDBException;
    public void criarAvaliador(Usuario usuario) throws SistemaRHDBException;
}
