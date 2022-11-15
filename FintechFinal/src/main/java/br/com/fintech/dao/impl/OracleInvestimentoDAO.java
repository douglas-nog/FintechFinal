package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.bean.Investimento;
import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO{

	private Connection conexao;

	@Override
	public void cadastrar(Investimento investimento) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_INVESTIMENTO (CD_APLIC, T_USUARIO_NR_CPF, T_TP_INVEST_CD_INVEST, "
					+ "DT_APLICACAO, VL_INVESTIMENTO) VALUES (SQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getCpf());
			stmt.setInt(2, investimento.getTipoInvestimento());
			
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(3, data);
			
			stmt.setDouble(4, investimento.getValorInvestimento());
			
			stmt.executeUpdate();	
		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar!");
			
		}finally {
			
			try {
			stmt.close();
			conexao.close();
			
		}catch (SQLException e){
			e.printStackTrace();
			}	
		}
	}

	@Override
	public void atualizar(Investimento investimento) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "UPDATE T_INVESTIMENTO SET T_TP_INVEST_CD_INVEST = ?, DT_APLICACAO = ?, "
					+ "VL_INVESTIMENTO = ? WHERE CD_APLIC = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, investimento.getTipoInvestimento());
			
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(2, data);
			
			stmt.setDouble(3, investimento.getValorInvestimento());
			
			stmt.setInt(4, investimento.getCodigo());
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				stmt.close();
				conexao.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) {
		
		PreparedStatement stmt = null;
		
		try {
		conexao = ConnectionManager.getInstance().getConnection();
		
		String sql = "DELETE FROM T_INVESTIMENTO WHERE CD_APLIC = ?";
		stmt = conexao.prepareStatement(sql);
		
		stmt.setInt(1, codigo);		
		
		stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				stmt.close();
				conexao.close();
				
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public Investimento buscaPorCodigo(int codigoBusca) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		Investimento investimento = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_INVESTIMENTO WHERE CD_APLIC = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigoBusca);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigo = result.getInt("CD_APLIC");
				String cpf = result.getString("T_USUARIO_NR_CPF");
				int tipoInvestimento = result.getInt("T_TP_INVEST_CD_INVEST");
				
				java.sql.Date data = result.getDate("DT_APLICACAO");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				
				double valorInvestimento = result.getDouble("VL_INVESTIMENTO");
				
				investimento = new Investimento(codigo, cpf, tipoInvestimento, 
						dataInvestimento, valorInvestimento);
				}
			
			}catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				
				try {
					stmt.close();
					conexao.close();
					result.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
			}	
		}
		return investimento;
	}

	@Override
	public List<Investimento> listar() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Investimento> lista = new ArrayList<Investimento>();
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_INVESTIMENTO";
			stmt = conexao.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			while (result.next()) {
				int codigo = result.getInt("CD_APLIC");
				String cpf = result.getString("T_USUARIO_NR_CPF");
				int tipoInvestimento = result.getInt("T_TP_INVEST_CD_INVEST");
				
				java.sql.Date data = result.getDate("DT_APLICACAO");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				
				double valorInvestimento = result.getDouble("VL_INVESTIMENTO");
				
				Investimento investimento = new Investimento(codigo, cpf, tipoInvestimento, dataInvestimento, valorInvestimento);
				
				lista.add(investimento);
				}
			
			}catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				
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
