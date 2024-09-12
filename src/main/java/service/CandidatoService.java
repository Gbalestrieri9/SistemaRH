package service;

import dao.ICandidatoDao;
import dao.impl.CandidatoDaoImpl;
import exception.SistemaRHDBException;

public class CandidatoService {

    private ICandidatoDao candidatoDao;

    public CandidatoService(){
        this.candidatoDao = new CandidatoDaoImpl();
    }
    String mensagem = "";
    public String cadastrarHabilidade(int idUsuario,String categoria, String habilidade) {
        try {
            candidatoDao.CadastrarHabilidade(idUsuario,categoria, habilidade);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
        return mensagem;
    }
}
