package controller;

import dto.ClienteLogadoDto;
import service.AvaliadorService;
import service.CandidatoService;
import util.ConstantesUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class AvaliadorController {

    Scanner input = new Scanner(System.in);

    AvaliadorService avaliadorService;

    public AvaliadorController() throws SQLException {
        this.avaliadorService = new AvaliadorService();
    }

    public void retornaHabilidadesPorEmail() {
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_CATEGORIA);
        String email = input.nextLine();

        avaliadorService.retornaHabilidadesPorEmail(email);
    }
}
