package dao.impl;

import dao.IAvaliadorDao;
import dto.CategoriaEHabilidadeDto;
import exception.SistemaRHDBException;
import util.ConexaoUtil;
import util.ConstantesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliadorDaoImpl implements IAvaliadorDao {

    private CategoriaEHabilidadeDto categoriaEHabilidadeDto;
    private ConexaoUtil conexaoUtil = new ConexaoUtil();
    private Connection minhaConexao;

    public List<CategoriaEHabilidadeDto> retornaHabilidadesPorEmail(String email) throws SistemaRHDBException {
        String sql = "call inserir_habilidade(?)";
        List<CategoriaEHabilidadeDto> habilidades = new ArrayList<>();
        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            String categoria;
            String habilidade;

            while(rs.next()){
                categoria = rs.getString("categoria");
                habilidade = rs.getString("habilidade");
                categoriaEHabilidadeDto = new CategoriaEHabilidadeDto(categoria, habilidade);
                habilidades.add(categoriaEHabilidadeDto);
            }
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_CADASTRAR_HABILIDADE);
        }
        return habilidades;
    }

//    public void retornaHabilidadesPorCategoria(String categoria) throws SistemaRHDBException {
//        String sql = "call inserir_habilidade(?)";
//
//        try {
//            minhaConexao = conexaoUtil.conexao();
//            PreparedStatement ps = minhaConexao.prepareStatement(sql);
//
//            ps.setInt(1,idUsuario);
//            ps.setString(2, categoria);
//            ps.setString(3, habilidade);
//            ps.execute();
//            conexaoUtil.fecharConexao(minhaConexao);
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_CADASTRAR_HABILIDADE);
//        }
//    }
}