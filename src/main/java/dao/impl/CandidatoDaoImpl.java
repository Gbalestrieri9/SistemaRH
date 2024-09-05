package dao.impl;

import dao.ICandidatoDao;
import exception.SistemaRHDBException;
import util.ConexaoUtil;
import util.ConstantesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidatoDaoImpl implements ICandidatoDao {

    ConexaoUtil conexaoUtil = new ConexaoUtil();
    Connection minhaConexao;

    public void CadastrarHabilidade(int idUsuario,String categoria, String habilidade) throws SistemaRHDBException{
        String sql = "call inserir_habilidade(?, ?, ?)";

        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);

            ps.setInt(1,idUsuario);
            ps.setString(2, categoria);
            ps.setString(3, habilidade);
            ps.execute();
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_CADASTRAR_HABILIDADE);
        }
    }
}
