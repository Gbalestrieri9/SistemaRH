package dao.impl;

import dao.IAvaliadorDao;
import model.CategoriaEHabilidade;
import model.Usuario;
import model.Vaga;
import exception.DbException;
import exception.SistemaRHDBException;
import org.springframework.dao.DataAccessException;
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

    private CategoriaEHabilidade categoriaEHabilidade;
    private ConexaoUtil conexaoUtil = new ConexaoUtil();
    private Connection minhaConexao;

    public List<CategoriaEHabilidade> retornaHabilidadesPorEmail(String email) throws DataAccessException,SistemaRHDBException {
        String sql = "SELECT * FROM busca_habilidades_por_email(?)";
        List<CategoriaEHabilidade> habilidades = new ArrayList<>();
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
                categoriaEHabilidade = new CategoriaEHabilidade(categoria, habilidade);
                habilidades.add(categoriaEHabilidade);
            }
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (DbException | SQLException e){
            DbException.ErroSql(e);
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_BUSCAR_HABILIDADES);
        }
        return habilidades;
    }

    public List<Vaga> listarVagas() throws SistemaRHDBException {
        String sql = "SELECT * FROM listar_vagas()";
        List<Vaga> vagas = new ArrayList<>();
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
                Vaga vaga = new Vaga(data, descricao,numero);
                vagas.add(vaga);
            }
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_LISTAR_VAGAS);
        }
        return vagas;
    }

    public boolean inserirCandidatoVaga(int id, String email,String vagaNumero) throws DataAccessException {
        String sql = "CALL inserir_candidato_vaga(?,?)";

        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,vagaNumero);
            ps.execute();
            conexaoUtil.fecharConexao(minhaConexao);
            return true;
        }catch (DbException | SQLException e){
            DbException.ErroSql(e);
            return false;
        }
    }

    public void criarAvaliador(Usuario usuario) throws SistemaRHDBException {
        String sql = "CALL inserir_avaliador(?, ?, ?)";
        try {
            minhaConexao = conexaoUtil.conexao();
            PreparedStatement ps = minhaConexao.prepareStatement(sql);

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.execute();
            conexaoUtil.fecharConexao(minhaConexao);
        }catch (SQLException e){
            throw new SistemaRHDBException(ConstantesUtil.MENSAGEM_ERRO_CADASTRAR_AVALIADOR);
        }
    }
}