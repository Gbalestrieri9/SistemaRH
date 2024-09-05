package service;

import dao.ICandidatoDao;
import dao.impl.CandidatoDaoImpl;
import exception.SistemaRHDBException;

public class CandidatoService {

    ICandidatoDao candidatoDao;

    public CandidatoService(){
        this.candidatoDao = new CandidatoDaoImpl();
    }

    public void cadastrarHabilidade(String categoria, String habilidade) {
        try {
            candidatoDao.CadastrarHabilidade(categoria, habilidade);
        } catch (SistemaRHDBException e){
            System.out.println(e.getMessage());
        }
    }
}
