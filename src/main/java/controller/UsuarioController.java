package controller;

import dto.ClienteLogadoDto;
import service.UsuarioService;
import util.ConstantesUtil;

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
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_NOME);
        String nome = input.nextLine();
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_EMAIL);
        String email = input.nextLine();
        System.out.println(ConstantesUtil.MENSAGEM_ESCREVER_SENHA);
        String senha = input.nextLine();
        usuarioService.cadastrarUsuario(nome, email, senha);
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