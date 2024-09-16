package controller;

import dto.CategoriaEHabilidadeDto;
import dto.VagaDto;
import service.AvaliadorService;
import util.ConstantesUtil;
import util.EmailValidadorUtil;
import util.NomeValidadorUtil;
import util.SenhaValidadorUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AvaliadorController {

   private Scanner input = new Scanner(System.in);

   private AvaliadorService avaliadorService;

    public AvaliadorController() throws SQLException {
        this.avaliadorService = new AvaliadorService();
    }

    public void retornaHabilidadesPorEmail(int id) {
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_EMAIL_CANDIDATO);
        String email = input.nextLine();

        List<CategoriaEHabilidadeDto> habilidadeDtoList = new ArrayList<>();
        habilidadeDtoList= avaliadorService.retornaHabilidadesPorEmail(email);

        System.out.println("\nHabilidades do candidato: ");
        for (CategoriaEHabilidadeDto habilidadeDto : habilidadeDtoList )
        {
            System.out.println(habilidadeDto.toString());

        }
    }

    public void listarVagas(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<VagaDto> vagas = avaliadorService.listarVagas();
        System.out.println("\nLista de Vagas:");
        for (VagaDto vagaDto : vagas){
            vagaDto.setDataStr(sdf.format(vagaDto.getData()));
            System.out.println(vagaDto.toString());
        }
    }

    public void inserirCandidatoNaVaga(int id){
        listarVagas();

        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_EMAIL_CANDIDATO);
        String email = input.nextLine();

        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_VAGA_NUMERO);
        String vagaNumero = input.nextLine();

        boolean sucesso = avaliadorService.inserirCandidatoNaVaga(id,email,vagaNumero);
        if (sucesso){
            System.out.println(ConstantesUtil.MENSAGEM_SUCESSO_INSERIR_CANDIDATO);
        }else {
            System.out.println(ConstantesUtil.MENSAGEM_ERRO_INSERIR_CANDIDATO);
        }
    }

    public void cadastrarAvaliador(int id) {
        String nome;
        String email;
        String senha;
        while (true){
            System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_NOME_AVALIADOR);
            nome = input.nextLine();
            if (!NomeValidadorUtil.validateName(nome)) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_NOME_INVALIDO);
                continue;
            }
            System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_EMAIL_AVALIADOR);
            email = input.nextLine();
            if (!EmailValidadorUtil.isValidEmail(email)) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_EMAIL_INVALIDO);
                continue;
            }
            System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_SENHA_AVALIADOR);
            senha = input.nextLine();
            if (!SenhaValidadorUtil.isValidPassword(senha)) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_SENHA_INVALIDO);
                continue;
            }
            break;
        }
        avaliadorService.cadastrarAvaliador(nome, email, senha);
    }
}
