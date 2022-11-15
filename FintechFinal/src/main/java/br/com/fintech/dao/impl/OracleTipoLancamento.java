package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.TipoLancamento;
import br.com.fintech.dao.TipoLancamentoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleTipoLancamento implements TipoLancamentoDAO{

	private Connection conexao;
	
	@Override
	public void cadastrar(TipoLancamento tipoLancamento) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "INSERT INTO T_TIPO_LANCAMENTO (CD_TIPO, DS_TIPO) VALUER (SQ_TIPO_LANCAMENTO.NEXTVAL, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new DBException("Erro ao cadastrar!");
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
	public void atualizar(TipoLancamento tipoLancamento) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_TIPO_LANCAMENTO SET DS_TIPO = ? WHERE CD_TIPO = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, tipoLancamento.getDescricaoLancamento());
			stmt.setInt(2, tipoLancamento.getCodigoTipoLancamento());
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro do atualizar registro!");
		
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
	public void remover(int codigo) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_TIPO_LANCAMENTO WHERE CD_TIPO = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover registro");
			
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
	public TipoLancamento buscaPorCodigo(int codigoBusca) {
		
		TipoLancamento tipoLancamento = new TipoLancamento();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT FROM T_TIPO_LANCAMENTO WHERE CD_TIPO = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigoBusca);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigoLancamento = tipoLancamento.getCodigoTipoLancamento();
				String descricaoTpLancamento = tipoLancamento.getDescricaoLancamento();
				
				tipoLancamento = new TipoLancamento(codigoLancamento, descricaoTpLancamento);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				
				try {
					stmt.close();
					conexao.close();
					result.close();
					
				} catch (Exception e) {
					e.printStackTrace();
			}
		}
		
		
		return tipoLancamento;
	}

	@Override
	public List<TipoLancamento> listar() {
		
		List<TipoLancamento> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_TIPO_LANCAMENTO";
			stmt = conexao.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			while (result.next()) {
				int codigoLancamento = result.getInt("CD_TIPO");
				String descricaoLancamento = result.getString("DS_TIPO");
				
				TipoLancamento tipoLancamento = new TipoLancamento(codigoLancamento, descricaoLancamento);
				lista.add(tipoLancamento);
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
