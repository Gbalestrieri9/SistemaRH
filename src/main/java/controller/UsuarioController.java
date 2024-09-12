package controller;

import dto.ClienteLogadoDto;
import exception.EmailException;
import exception.NomeException;
import exception.SenhaException;
import service.UsuarioService;
import util.ConstantesUtil;
import util.EmailValidadorUtil;
import util.NomeValidadorUtil;
import util.SenhaValidadorUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class UsuarioController {

    private Scanner input = new Scanner(System.in);
    private UsuarioService usuarioService;
    private ClienteLogadoDto clienteLogado;

    public UsuarioController() throws SQLException {
        this.usuarioService = new UsuarioService();
    }

    public void cadastrar() {
        String nome;
        String email;
        String senha;
        while (true){
            System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_NOME);
            nome = input.nextLine();
            if (!NomeValidadorUtil.validateName(nome)) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_NOME_INVALIDO);
                continue;
            }
            System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_EMAIL);
            email = input.nextLine();
            if (!EmailValidadorUtil.isValidEmail(email)) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_EMAIL_INVALIDO);
                continue;
            }
            System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_SENHA);
            senha = input.nextLine();
            if (!SenhaValidadorUtil.isValidPassword(senha)) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_SENHA_INVALIDO);
                continue;
            }
            break;
        }
        usuarioService.cadastrarUsuario(nome, email, senha);
        System.out.println(ConstantesUtil.MENSAGEM_SUCESSO_CADASTRO);
    }

    public int login() {
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_EMAIL);
        String email = input.nextLine();
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_SENHA);
        String senha = input.nextLine();

        int idConta=0;
        idConta = usuarioService.loginUsuario(email, senha);
        clienteLogado = new ClienteLogadoDto(idConta);
        if (clienteLogado != null) {
            System.out.println("Logado com sucesso");
        } else {
            System.out.println("Credenciais invalidas. Tente novamente.");
        }
        return idConta;
    }

    public String getTipoConta(int id) {

        return usuarioService.getTipoConta(id);
    }
}