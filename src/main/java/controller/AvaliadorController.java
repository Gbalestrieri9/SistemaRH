package controller;

import model.CategoriaEHabilidade;
import model.Usuario;
import model.Vaga;
import service.AvaliadorService;
import util.ConstantesUtil;
import util.EmailValidadorUtil;
import util.NomeValidadorUtil;
import util.SenhaValidadorUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

        List<CategoriaEHabilidade> habilidadeDtoList;
        habilidadeDtoList= avaliadorService.retornaHabilidadesPorEmail(email);

        if(habilidadeDtoList != null && !habilidadeDtoList.isEmpty()){
            System.out.println("\nHabilidades do candidato: ");

            for (CategoriaEHabilidade habilidadeDto : habilidadeDtoList )
            {
                System.out.println(habilidadeDto.toString());
            }
        }
    }

    public void listarVagas(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Vaga> vagas = avaliadorService.listarVagas();
        System.out.println("\nLista de Vagas:");
        for (Vaga vaga : vagas){
            vaga.setDataStr(sdf.format(vaga.getData()));
            System.out.println(vaga.toString());
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
        Usuario usuario = new Usuario();
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
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        avaliadorService.cadastrarAvaliador(usuario);
    }
}
