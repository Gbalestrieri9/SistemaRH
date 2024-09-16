package controller;

import model.CategoriaHabilidade;
import service.CandidatoService;
import util.ConstantesUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidatoController {

    private Scanner input = new Scanner(System.in);

    private CandidatoService candidatoService;

    public CandidatoController() throws SQLException {
        this.candidatoService = new CandidatoService();
    }

    public void cadastrarHabilidade(int id) {

        List<CategoriaHabilidade> categoria = new ArrayList<>();
        String habilidade = "";

        categoria.add(CategoriaHabilidade.Tecnologia);
        categoria.add(CategoriaHabilidade.Saude);
        categoria.add(CategoriaHabilidade.Arte);
        categoria.add(CategoriaHabilidade.Design);
        categoria.add(CategoriaHabilidade.Administração);
        categoria.add(CategoriaHabilidade.Engenharia);

        for (CategoriaHabilidade cat : categoria) {
            System.out.println(cat);
        }
        boolean habilidadeCheck = false;
        String categoriaEscolhida = "";
        while (!habilidadeCheck) {
            System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_CATEGORIA);
            categoriaEscolhida = input.nextLine();
            for (CategoriaHabilidade cat : categoria) {
                if (categoriaEscolhida.equalsIgnoreCase(cat.toString())) {
                    System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_HABILIDADE);
                    habilidade = input.nextLine();
                    habilidadeCheck = true;
                    break;
                }
            }
            if (!habilidadeCheck) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_DIGITACAO_CATEGORIA_HABILIDADE);
                for (CategoriaHabilidade cat : categoria) {
                    System.out.println(cat);
                }
            }
        }

        candidatoService.cadastrarHabilidade(id, categoriaEscolhida, habilidade);
    }
}
