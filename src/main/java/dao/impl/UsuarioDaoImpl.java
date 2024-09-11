package dao.impl;

import dao.IUsuarioDao;
import exception.SistemaRHDBException;
import util.ConexaoUtil;
import util.ConstantesUtil;

import java.sql.*;

public class UsuarioDaoImpl implements IUsuarioDao {

    private ConexaoUtil conexaoUtil = new ConexaoUtil();
    private Connection minhaConexao;

    public void criarUsuario(String nome, String email, String senha) throws SistemaRHDBException {
        String sql = "CALL inserir_usuario(?, ?, ?)";

        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);
            ps.execute();
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_CADASTRAR_USUARIO);
        }

    }


    public int loginUsuario(String email,String senha) throws SistemaRHDBException{
        String sql = "SELECT * FROM login_usuario(?,?)";
        int id;

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

    public String getTipoConta(int id) throws SistemaRHDBException {
        String sql = "SELECT * FROM buscar_tipo_conta(?)";
        String tipo;
        try{
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            tipo = rs.getString("buscar_tipo_conta");

        }catch (SQLException e){

            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_LOGIN_USUARIO);
        }
        return tipo;
    }
}