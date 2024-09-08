package controller;

import dto.CategoriaEHabilidadeDto;
import dto.ClienteLogadoDto;
import model.Habilidade;
import service.AvaliadorService;
import service.CandidatoService;
import util.ConstantesUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvaliadorController {

    Scanner input = new Scanner(System.in);

    AvaliadorService avaliadorService;

    public AvaliadorController() throws SQLException {
        this.avaliadorService = new AvaliadorService();
    }

    public void retornaHabilidadesPorEmail(int id) {
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_CATEGORIA);
        String email = input.nextLine();

        List<CategoriaEHabilidadeDto> habilidadeDtoList = new ArrayList<>();
        habilidadeDtoList= avaliadorService.retornaHabilidadesPorEmail(id,email);

        System.out.println("\nHabilidades do candidato: ");
        for (CategoriaEHabilidadeDto habilidadeDto : habilidadeDtoList )
        {
            System.out.println(habilidadeDto.toString());

        }
    }
}
