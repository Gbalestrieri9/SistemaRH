package controller;

import dto.ClienteLogadoDto;

import java.sql.SQLException;

public class MenuController {

    UsuarioController usuarioController;
    CandidatoController candidatoController;
    AvaliadorController avaliadorController;

    private int id;

    public MenuController() throws SQLException {
        this.usuarioController = new UsuarioController();
        this.candidatoController = new CandidatoController();
        this.avaliadorController = new AvaliadorController();
    }

    public void controle(int acaoSelecionada) {
        switch (acaoSelecionada) {
            case 1:
                usuarioController.cadastrar();
                break;
            case 2:
                id = usuarioController.login();
                break;
            case 3:
                candidatoController.cadastrarHabilidade(id);
                break;
            case 4:
                avaliadorController.retornaHabilidadesPorEmail(id);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
