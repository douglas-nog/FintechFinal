package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.TipoTelefone;
import br.com.fintech.dao.TipoTelefoneDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleTipoTelefoneDAO implements TipoTelefoneDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(TipoTelefone tipoTelefone) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_TP_TEL (CD_TIPO_FONE, DS_TIPO_TELEFONE) VALUES (SQ_TIPO_TELEFONE.NEXTVAL, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, tipoTelefone.getDescricaoTipoTelefone());
			
			stmt.executeUpdate();
			
		} catch (SQLException e ){
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar");
			
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
	public void atualizar(TipoTelefone tipoTelefone) throws DBException {
		
		PreparedStatement stmt = null; 
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE TABLE T_TIPO_TEL SET DS_TIPO_TELEFONE = ? WHERE CD_TIPO_FONE = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, tipoTelefone.getDescricaoTipoTelefone());
			stmt.setInt(2, tipoTelefone.getCodigoTipoTelefone());			
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar!");
			
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
			String sql = "DELETE FROM T_TP_TEL WHERE CD_TIPO_FONE = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir registro!");
			
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
	public TipoTelefone buscaPorCodigo(int codigoBusca) {
		
		TipoTelefone tipoTelefone = new TipoTelefone();
		ResultSet result = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_TIPO_TEL WHERE CD_TIPO_FONE = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigoBusca);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigoTipo = result.getInt("CD_TIPO_FONE");
				String descricaoTipoTelefone = result.getString("DS_TIPO_TELEFONE");
				
				tipoTelefone = new TipoTelefone(codigoTipo, descricaoTipoTelefone);
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
		return tipoTelefone;
	}

	@Override
	public List<TipoTelefone> listar() {
		
		List<TipoTelefone> lista = new ArrayList<TipoTelefone>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_TIPO_TEL";
			stmt = conexao.prepareStatement(sql);

			
			result = stmt.executeQuery();
			
			while (result.next()) {
				int codigoTipo = result.getInt("CD_TIPO_FONE");
				String descricaoTipoTelefone = result.getString("DS_TIPO_TELEFONE");
				
				TipoTelefone tipoTelefone = new TipoTelefone(codigoTipo, descricaoTipoTelefone);
				lista.add(tipoTelefone);
				
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
