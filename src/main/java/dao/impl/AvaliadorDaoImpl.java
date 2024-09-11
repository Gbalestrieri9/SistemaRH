package dao.impl;

import dao.IAvaliadorDao;
import dto.CategoriaEHabilidadeDto;
import dto.VagaDto;
import exception.SistemaRHDBException;
import util.ConexaoUtil;
import util.ConstantesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AvaliadorDaoImpl implements IAvaliadorDao {

    private CategoriaEHabilidadeDto categoriaEHabilidadeDto;
    private ConexaoUtil conexaoUtil = new ConexaoUtil();
    private Connection minhaConexao;

    public List<CategoriaEHabilidadeDto> retornaHabilidadesPorEmail(String email) throws SistemaRHDBException {
        String sql = "SELECT * FROM busca_habilidades_por_email(?)";
        List<CategoriaEHabilidadeDto> habilidades = new ArrayList<>();
        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ps.setString(1,email);
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

    public List<VagaDto> listarVagas() throws SistemaRHDBException {
        String sql = "SELECT * FROM listar_vagas()";
        List<VagaDto> vagaDtos = new ArrayList<>();
        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Date data;
            String descricao;
            String numero;

            while(rs.next()){
                data = rs.getDate("vaga_data");
                descricao = rs.getString("vaga_descricao");
                numero = rs.getString("vaga_numero");
                VagaDto vaga = new VagaDto(data, descricao,numero);
                vagaDtos.add(vaga);
            }
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_LISTAR_VAGAS);
        }
        return vagaDtos;
    }

    public void inserirCandidatoVaga(int id, String email,String vagaNumero) throws SistemaRHDBException{
        String sql = "CALL inserir_candidato_vaga(?,?)";

        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,vagaNumero);
            ps.execute();
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_INSERIR_CANDIDATO_DB);
        }
    }
}