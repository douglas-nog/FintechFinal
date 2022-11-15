package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.TipoInvestimento;
import br.com.fintech.dao.TipoInvestimentoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;


public class OracleTipoInvestimentoDAO implements TipoInvestimentoDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(TipoInvestimento tipoInvestimento) throws DBException{
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "INSERT INTO T_TP_INVEST (CD_INVEST, DS_BANCO, DS_INVESTIMENTO) "
					+ "VALUES (SQ_TIPO_INVESTIMENTO.NEXTVAL, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, tipoInvestimento.getNumeroBanco());
			stmt.setString(2, tipoInvestimento.getDescricaoInvestimento());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar!");
			
		} finally {
			
			try {
				stmt.close();
				conexao.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(TipoInvestimento tipoInvestimento) throws DBException{
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_TP_INVEST SET DS_BANCO = ?, DS_INVESTIMENTO = ? WHERE CD_INVEST = ? ";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, tipoInvestimento.getNumeroBanco());
			stmt.setString(2, tipoInvestimento.getDescricaoInvestimento());
			stmt.setInt(3, tipoInvestimento.getCdTipoInvestimento());
			
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar!");
			
		} finally {
			
			try {
				stmt.close();

			stmt.executeUpdate();
				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			stmt = conexao.prepareStatement("DELETE FROM T_TP_INVEST WHERE CD_INVEST = ?");
			
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover!");
			
		}finally {
			
			try { 
				
				stmt.close();
				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public TipoInvestimento buscaPorCodigo(int codigoBusca) {
		
		TipoInvestimento tipoInvestimento = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_TP_INVEST WHERE CD_INVEST = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigoBusca);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int cdTipo = result.getInt("CD_INVEST");
				int nrBanco = result.getInt("DS_BANCO");
				String descricaoTipo = result.getString("DS_INVESTIMENTO");
				
				tipoInvestimento = new TipoInvestimento(cdTipo, nrBanco, descricaoTipo);
				
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally { 
				
				try {
					stmt.close();
					conexao.close();
					result.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return tipoInvestimento;
	}

	@Override
	public List<TipoInvestimento> listar() {
		
		List<TipoInvestimento> lista = new ArrayList<TipoInvestimento>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_TP_INVEST";
			stmt = conexao.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			while(result.next()) {
				int cdTipo = result.getInt("CD_INVEST");
				int nrBanco = result.getInt("DS_BANCO");
				String descricaoTipo = result.getString("DS_INVESTIMENTO");
				
				TipoInvestimento tipoInvestimento = new TipoInvestimento(cdTipo, nrBanco, descricaoTipo);
				lista.add(tipoInvestimento);
				
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally { 
				
				try {
					stmt.close();
					conexao.close();
					result.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return lista;
	}
}
