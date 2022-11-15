package br.com.fintech.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.bean.Receita;
import br.com.fintech.dao.ReceitaDAO;
import br.com.fintech.singleton.ConnectionManager;


public class OracleReceitaDAO implements ReceitaDAO{

	private Connection conexao;
	
	public void Cadastrar(Receita receita) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_RECEITA(CD_RECEITA, T_USUARIO_NR_CPF, T_TIPO_CD_TIPO, DS_RECEITA, VL_RECEITA, DT_RECEITA, DS_RECORRENCIA, NR_QTD_REPETICAO) VALUES (SQ_RECEITA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, receita.getCpf());
			stmt.setInt(2, receita.getTipo());
			stmt.setString(3, receita.getDescricao());
			stmt.setDouble(4, receita.getValor_receita());
			
			java.sql.Date data = new java.sql.Date(receita.getData_receita().getTimeInMillis());
			stmt.setDate(5, data);
			
			stmt.setString(6, receita.getRecorrencia());
			stmt.setInt(7, receita.getQtd_repeticao());
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
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
	
	public List <Receita> listar(){
		
		List<Receita> lista = new ArrayList<Receita>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_RECEITA");
			result = stmt.executeQuery();
		
		while(result.next()) {
			int codigo = result.getInt("CD_RECEITA");
			String cpf = result.getString("T_USUARIO_NR_CPF");
			int tipo = result.getInt("T_TIPO_CD_TIPO");
			String descricao = result.getString("DS_RECEITA");
			double valor_receita = result.getDouble("VL_RECEITA");
			java.sql.Date data = result.getDate("DT_RECEITA");
			Calendar data_receita = Calendar.getInstance();
			data_receita.setTimeInMillis(data.getTime());
			String recorrencia = result.getString("DS_RECORRENCIA");
			int qtd_repeticao = result.getInt("NR_QTD_REPETICAO");
			Receita receita = new Receita(codigo, cpf, tipo, descricao, valor_receita, data_receita, recorrencia, qtd_repeticao);
			
			lista.add(receita);
			}		
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				stmt.close();
				conexao.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public void remover(int codigo) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_RECEITA WHERE CD_RECEITA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			
			try{
				stmt.close();
				conexao.close();
				
			}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	}
	
	public Receita buscaPorCD(int codigoBusca) {
		
		Receita receita = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_RECEITA WHERE CD_RECEITA = ?");
			stmt.setInt(1, codigoBusca);
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigo = result.getInt("CD_RECEITA");
				String cpf = result.getString("T_USUARIO_NR_CPF");
				int tipo = result.getInt("T_TIPO_CD_TIPO");
				String descricao = result.getString("DS_RECEITA");
				double valor_receita = result.getDouble("VL_RECEITA");
				java.sql.Date data = result.getDate("DT_RECEITA");
				Calendar data_receita = Calendar.getInstance();
				data_receita.setTimeInMillis(data.getTime());
				String recorrencia = result.getString("DS_RECORRENCIA");
				int qtd_repeticao = result.getInt("NR_QTD_REPETICAO");
				receita = new Receita(codigo, cpf, tipo, descricao, valor_receita, data_receita, recorrencia, qtd_repeticao);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				conexao.close();
				stmt.close();
				result.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return receita;
	//System.out.println(funcionario.getCodigo()+ " " + funcionario.getNome() + " " + funcionario.getEmail() + " " + funcionario.getSalario() + " " + funcionario.getDataContratacao().getTime());

	}
	
	public void atualizar(Receita receita) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_RECEITA SET DS_RECEITA = ?, VL_RECEITA = ?, DT_RECEITA =?, DS_RECORRENCIA = ?, NR_QTD_REPETICAO = ? WHERE CD_RECEITA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, receita.getDescricao());
			stmt.setDouble(2, receita.getValor_receita());
			java.sql.Date data = new java.sql.Date(receita.getData_receita().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setString(4, receita.getRecorrencia());
			stmt.setInt(5, receita.getQtd_repeticao());
			stmt.setInt(6, receita.getCodigo());
			
			stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			
			try {
				stmt.close();
				conexao.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}