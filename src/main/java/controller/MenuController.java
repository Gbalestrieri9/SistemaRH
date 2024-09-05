package controller;

import java.sql.SQLException;

public class MenuController {

    UsuarioController usuarioController;
    CandidatoController candidatoController;

    public MenuController() throws SQLException {
        this.usuarioController = new UsuarioController();
        this.candidatoController = new CandidatoController();
    }

    public void controle(int acaoSelecionada) {
        switch (acaoSelecionada) {
            case 1:
                usuarioController.cadastrar();
                break;
            case 2:
                usuarioController.login();
                break;
            case 3:
                candidatoController.cadastrarHabilidade();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
