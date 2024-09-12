package controller;

import service.CandidatoService;
import util.ConstantesUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class CandidatoController {

    private Scanner input = new Scanner(System.in);

    private CandidatoService candidatoService;

    public CandidatoController() throws SQLException {
        this.candidatoService = new CandidatoService();
    }

    public void cadastrarHabilidade(int id) {
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_CATEGORIA);
        String categoria = input.nextLine();
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_HABILIDADE);
        String habilidade = input.nextLine();

        candidatoService.cadastrarHabilidade(id,categoria,habilidade);
        System.out.println(ConstantesUtil.MENSAGEM_SUCESSO_CADASTRO_HABILIDADE);
    }
}
