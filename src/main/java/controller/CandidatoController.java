package controller;

import dto.ClienteLogadoDto;
import service.CandidatoService;
import service.UsuarioService;
import util.ConstantesUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class CandidatoController {

    Scanner input = new Scanner(System.in);

    CandidatoService candidatoService;
    ClienteLogadoDto clienteLogado;

    public CandidatoController() throws SQLException {
        this.candidatoService = new CandidatoService();
    }

    public void cadastrarHabilidade(int id) {
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_CATEGORIA);
        String categoria = input.nextLine();
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_HABILIDADE);
        String habilidade = input.nextLine();

        candidatoService.cadastrarHabilidade(id,categoria,habilidade);
    }
}
