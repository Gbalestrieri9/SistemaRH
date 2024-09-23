package service;

import dao.IAvaliadorDao;
import dao.impl.AvaliadorDaoImpl;
import model.CategoriaEHabilidade;
import model.Usuario;
import model.Vaga;
import exception.SistemaRHDBException;
import util.ConstantesUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliadorService {

   private IAvaliadorDao AvaliadorDao;

    public AvaliadorService() throws SQLException {
        this.AvaliadorDao = new AvaliadorDaoImpl();
    }

    public List<CategoriaEHabilidade> retornaHabilidadesPorEmail(String email) {
        try {
            return AvaliadorDao.retornaHabilidadesPorEmail(email);
        } catch (SistemaRHDBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Vaga> listarVagas(){
        try {
            return AvaliadorDao.listarVagas();
        }catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean inserirCandidatoNaVaga(int id, String email, String vagaNumero){
        try {
            if (AvaliadorDao.inserirCandidatoVaga(id,email,vagaNumero)){
                return true;
            }else {
                return false;
            }
        }catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void cadastrarAvaliador(Usuario usuario) {
        try {
            AvaliadorDao.criarAvaliador(usuario);
            System.out.println(ConstantesUtil.MENSAGEM_SUCESSO_CADASTRO);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
    }
}
