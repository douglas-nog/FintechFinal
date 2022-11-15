package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.ContaBancaria;
import br.com.fintech.dao.ContaBancariaDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleContaBancaria implements ContaBancariaDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(ContaBancaria contaBancaria) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "INSERT INTO T_CTA_BANCARIA (CD_CONTA, T_USUARIO_T_CPF, NR_BANCO, NR_AGENCIA, NR_CONTA) "
					+ "VALUES (SQ_CTA_BANCARIA.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, contaBancaria.getCpf());
			stmt.setInt(2, contaBancaria.getCodigoBanco());
			stmt.setInt(3, contaBancaria.getNumeroAgencia());
			stmt.setInt(4, contaBancaria.getNumeroConta());
			
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
	public void atualizar(ContaBancaria contaBancaria) throws DBException {

		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "UPDATE T_CTA_BANCARIA SET NR_BANCO = ?, NR_AGENCIA = ? , NR_CONTA = ? WHERE CD_CONTA = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, contaBancaria.getCodigoBanco());
			stmt.setInt(2, contaBancaria.getNumeroAgencia());
			stmt.setInt(3, contaBancaria.getNumeroConta());
			stmt.setInt(4, contaBancaria.getCodigoContaBancaria());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar registro!");
			
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
	public void remover(int codigo) throws DBException {

		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "DELETE FROM T_CTA_BANCARIA WHERE CD_CONTA = ?";
			
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
	public ContaBancaria buscaPorCodigo(int codigoBusca) {
		
		ContaBancaria contaBancaria = new ContaBancaria();
		ResultSet result = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_CTA_BANCARIA WHERE CD_CONTA = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigoBusca);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigoConta = result.getInt("CD_CONTA");
				String cpf = result.getString("T_USURIO_NR_CPF");
				int numeroBanco = result.getInt("NR_BANCO");
				int numeroAgencia = result.getInt("NR_AGENCIA");
				int numeroConta =result.getInt("NR_CONTA");
				
				contaBancaria = new ContaBancaria(codigoConta, cpf, numeroBanco, numeroAgencia, numeroConta);
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
		return contaBancaria;
	}


	@Override
	public List<ContaBancaria> listar() {

		List<ContaBancaria> lista = new ArrayList<ContaBancaria>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_CTA_BANCARIA";
			stmt = conexao.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			while(result.next()) {
				int codigoConta = result.getInt("CD_CONTA");
				String cpf = result.getString("T_USURIO_NR_CPF");
				int numeroBanco = result.getInt("NR_BANCO");
				int numeroAgencia = result.getInt("NR_AGENCIA");
				int numeroConta =result.getInt("NR_CONTA");
				
				ContaBancaria contaBancaria = new ContaBancaria(codigoConta, cpf, numeroBanco, numeroAgencia, numeroConta);
				lista.add(contaBancaria);
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
