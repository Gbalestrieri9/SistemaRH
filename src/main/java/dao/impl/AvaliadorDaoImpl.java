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

    public List<CategoriaEHabilidadeDto> retornaHabilidadesPorEmail(int id,String email) throws SistemaRHDBException {
        String sql = "select * from busca_habilidades_por_email(?,?)";
        List<CategoriaEHabilidadeDto> habilidades = new ArrayList<>();
        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,email);
            ResultSet rs = ps.executeQuery();

            String categoria;
            String habilidade;

            while(rs.next()){
                categoria = rs.getString("habilidade_categoria");
                habilidade = rs.getString("habilidade_habilidade");
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

//    public String listarVagas(int id) throws SistemaRHDBException {
//        String sql = "select * from busca_habilidades_por_email(?,?)";
//        List<CategoriaEHabilidadeDto> habilidades = new ArrayList<>();
//        try {
//            minhaConexao = conexaoUtil.conexao();
//            PreparedStatement ps = minhaConexao.prepareStatement(sql);
//            ps.setInt(1,id);
//            ResultSet rs = ps.executeQuery();
//
//            String categoria;
//            String habilidade;
//
//            while(rs.next()){
//                categoria = rs.getString("habilidade_categoria");
//                habilidade = rs.getString("habilidade_habilidade");
//                categoriaEHabilidadeDto = new CategoriaEHabilidadeDto(categoria, habilidade);
//                habilidades.add(categoriaEHabilidadeDto);
//            }
//            conexaoUtil.fecharConexao(minhaConexao);
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_CADASTRAR_HABILIDADE);
//        }
//        return habilidades;
//    }

}