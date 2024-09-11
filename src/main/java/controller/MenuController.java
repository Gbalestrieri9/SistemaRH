package controller;


import util.ConstantesUtil;

import java.sql.SQLException;

public class MenuController {

    private UsuarioController usuarioController;
    private CandidatoController candidatoController;
    private AvaliadorController avaliadorController;

    private int id;
    private String tipo;

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
                tipo = usuarioController.getTipoConta(id);
                break;
            case 3:
                if ("candidato".equalsIgnoreCase(tipo)){
                    candidatoController.cadastrarHabilidade(id);
                }else {
                    System.out.println(ConstantesUtil.MENSAGEM_TIPO_AVALIADOR_NAO_PERMITIDO);
                }

                break;
            case 4:
                if ("avaliador".equalsIgnoreCase(tipo)){
                    avaliadorController.retornaHabilidadesPorEmail(id);
                }else {
                    System.out.println(ConstantesUtil.MENSAGEM_TIPO_CANDIDATO_NAO_PERMITIDO);
                }
                break;
            case 5:
                if ("avaliador".equalsIgnoreCase(tipo)){
                    avaliadorController.inserirCandidatoNaVaga(id);
                }else {
                    System.out.println(ConstantesUtil.MENSAGEM_TIPO_CANDIDATO_NAO_PERMITIDO);
                }
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
