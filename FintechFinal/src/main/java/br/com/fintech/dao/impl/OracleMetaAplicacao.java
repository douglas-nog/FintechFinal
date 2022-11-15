package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.bean.MetaAplicacao;
import br.com.fintech.dao.MetaAplicacaoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleMetaAplicacao implements MetaAplicacaoDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(MetaAplicacao metaAplicacao) throws DBException {

		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "INSERT INTO T_META_APLIC (CD_META, T_TP_INVEST_CD_INVEST, T_USUARIO_NR_CPF, DT_CRIACAO"
					+ "DT_FIM, VL_META) VALUES (SQ_META.NEXTVAL, ?, ?, ?, ?, ? )";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, metaAplicacao.getCodigoInvestimento());
			stmt.setString(2, metaAplicacao.getCpf());

			java.sql.Date data = new java.sql.Date(metaAplicacao.getDataCriacao().getTimeInMillis());
			stmt.setDate(3, data);
			
			java.sql.Date dataFim = new java.sql.Date(metaAplicacao.getDataFinal().getTimeInMillis());
			stmt.setDate(4, dataFim);
			
			stmt.setDouble(5, metaAplicacao.getValorMeta());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar registro!");
			
		}finally {
			
			try {
				stmt.close();
				conexao.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(MetaAplicacao metaAplicacao) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "UPDATE T_META_APLIC T_TP_INVEST_CD_INVEST = ?, DT_CRIACAO = ?, DT_FIM = ?,"
					+ " VL_META = ? WHERE CD_META = ?";
			
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, metaAplicacao.getCodigoInvestimento());
			
			java.sql.Date data = new java.sql.Date(metaAplicacao.getDataCriacao().getTimeInMillis());
			stmt.setDate(2, data);
			
			java.sql.Date data2 = new java.sql.Date(metaAplicacao.getDataFinal().getTimeInMillis());
			stmt.setDate(3, data2);
			
			stmt.setDouble(4, metaAplicacao.getValorMeta());
			stmt.setInt(4, metaAplicacao.getCodigoMeta());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar registro!");
			
		} finally {
			
		}try {
			stmt.close();
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(int codigo) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE * FROM T_META WHERE CD_META = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover registro!");
			
		} finally {
			
			try {
				stmt.close();
				conexao.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public MetaAplicacao buscaPorCodigo(int codigoBusca) {

		MetaAplicacao metaAplicacao = new MetaAplicacao();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_META WHERE CD_META = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigoBusca);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigoMeta = result.getInt("CD_META");
				int tipoInvet = result.getInt("T_TP_INVEST_CD_INVEST");
				String cpf = result.getString("T_USUARIO_T_CPF");
				
				java.sql.Date data = result.getDate("DT_CRIACAO");
				Calendar dataCriacao = Calendar.getInstance();
				dataCriacao.setTimeInMillis(data.getTime());
				
				java.sql.Date data2 = result.getDate("DT_FIM");
				Calendar dataFim = Calendar.getInstance();
				dataCriacao.setTimeInMillis(data2.getTime());
				
				double valorMeta = result.getDouble("VL_META");
				
				metaAplicacao = new MetaAplicacao(codigoMeta, tipoInvet, cpf, dataCriacao, dataFim, valorMeta);
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				
				try {
					stmt.close();
					conexao.close();
					result.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		return metaAplicacao;
	}

	@Override
	public List<MetaAplicacao> listar() {

		List<MetaAplicacao> lista = new ArrayList<MetaAplicacao>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_META";
			stmt = conexao.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			while(result.next()) {
				int codigoMeta = result.getInt("CD_META");
				int tipoInvet = result.getInt("T_TP_INVEST_CD_INVEST");
				String cpf = result.getString("T_USUARIO_T_CPF");
				
				java.sql.Date data = result.getDate("DT_CRIACAO");
				Calendar dataCriacao = Calendar.getInstance();
				dataCriacao.setTimeInMillis(data.getTime());
				
				java.sql.Date data2 = result.getDate("DT_FIM");
				Calendar dataFim = Calendar.getInstance();
				dataCriacao.setTimeInMillis(data2.getTime());
				
				double valorMeta = result.getDouble("VL_META");
				
				MetaAplicacao metaAplicacao = new MetaAplicacao(codigoMeta, tipoInvet, cpf, dataCriacao, dataFim, valorMeta);
				lista.add(metaAplicacao);
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				
				try {
					stmt.close();
					conexao.close();
					result.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		return lista;
	}

}
