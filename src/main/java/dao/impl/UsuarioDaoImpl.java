package dao.impl;

import dao.IUsuarioDao;
import exception.SistemaRHDBException;
import model.Tipo;
import org.springframework.jdbc.core.JdbcTemplate;
import util.ConexaoUtil;
import util.ConstantesUtil;

import java.sql.*;

public class UsuarioDaoImpl implements IUsuarioDao {

    ConexaoUtil conexaoUtil = new ConexaoUtil();
    Connection minhaConexao;

    public void criarUsuario(String nome, String email, String senha, String tipo) throws SistemaRHDBException {
        String sql = "call inserir_usuario(?, ?, ?, ?)";

        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);
            ps.setString(4, tipo);
            ps.execute();
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_CADASTRAR_USUARIO);
        }

    }


    public long loginUsuario(String email,String senha) throws SistemaRHDBException{
        String sql = "SELECT login_usuario(?,?)";
        long id;

        try{
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,senha);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("login_usuario");


        }catch (SQLException e){

            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_LOGIN_USUARIO);
        }
            return id;
    }
}