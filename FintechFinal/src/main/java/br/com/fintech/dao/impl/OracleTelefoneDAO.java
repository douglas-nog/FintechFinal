package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Telefone;
import br.com.fintech.dao.TelefoneDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleTelefoneDAO implements TelefoneDAO{

	private Connection conexao;
	
	@Override
	public void cadastrar(Telefone telefone) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "INSERT INTO T_TEL (NR_TEL_COMPLETO, T_USUARIO_NR_CPF, T_TP_TEL_CD_TIPO_FONE, "
					+ "NR_DDD, NR_TELEFONE) VALUES (SQ_TELEFONE.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, telefone.getCpf());
			stmt.setInt(2, telefone.getTipoTelefone());
			stmt.setString(3, telefone.getDdd());
			stmt.setString(4, telefone.getNumeroTelefone());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar registro");
			
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
	public void atualizar(Telefone telefone) throws DBException {

		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_TEL SET T_TP_TEL_CD_TIPO_FONE = ?, NR_DDD = ?, NR_TELEFONE = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, telefone.getTipoTelefone());
			stmt.setString(2, telefone.getDdd());
			stmt.setString(3, telefone.getNumeroTelefone());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o registro!");
			
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
			String sql = "DELETE FROM T_TEL WHERE CD_TELEFONE = ?";
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
	public Telefone buscaPorCodigo(int codigoBusca) {
		
		Telefone telefone = new Telefone();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_TEL WHERE CD_TELEFONE = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigoBusca);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigoTelefone = result.getInt("CD_TELEFONE");
				String cpf = result.getString("T_USUARIO_NR_CPF");
				int tipoTelefone = result.getInt("T_TP_TEL_CD_TIPO_FONE");
				String ddd = result.getString("NR_DDD");
				String numero = result.getString("NR_TELEFONE");
				
				telefone = new Telefone(codigoTelefone, cpf, tipoTelefone, ddd, numero);
				
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
		return telefone;
	}

	@Override
	public List<Telefone> listar() {
		List<Telefone> lista = new ArrayList<Telefone>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_TEL";
			stmt = conexao.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigoTelefone = result.getInt("CD_TELEFONE");
				String cpf = result.getString("T_USUARIO_NR_CPF");
				int tipoTelefone = result.getInt("T_TP_TEL_CD_TIPO_FONE");
				String ddd = result.getString("NR_DDD");
				String numero = result.getString("NR_TELEFONE");
				
				Telefone telefone = new Telefone(codigoTelefone, cpf, tipoTelefone, ddd, numero);
				lista.add(telefone);
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
