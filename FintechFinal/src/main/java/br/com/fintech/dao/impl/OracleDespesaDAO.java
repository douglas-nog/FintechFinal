package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.bean.Despesa;
import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.singleton.ConnectionManager;

public class OracleDespesaDAO implements DespesaDAO{
	
	private Connection conexao;
	
	public void Cadastrar(Despesa despesa) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_DESPESA(CD_DESPESA, T_USUARIO_NR_CPF, T_TIPO_CD_TIPO, DS_DESPESA, VL_DESPESA, DT_DESPESA, DS_RECORRENCIA, NR_QTD_REPETICAO) VALUES (SQ_DESPESA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, despesa.getCpf());
			stmt.setInt(2, despesa.getTipo());
			stmt.setString(3, despesa.getDescricao());
			stmt.setDouble(4, despesa.getValor_despesa());
			java.sql.Date data = new java.sql.Date(despesa.getData_despesa().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.setString(6, despesa.getRecorrencia());
			stmt.setInt(7, despesa.getQtd_repeticao());
			
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
	
	public List <Despesa> listar(){
		
		List<Despesa> lista = new ArrayList<Despesa>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESA");
			result = stmt.executeQuery();
		
			while(result.next()) {
				int codigo = result.getInt("CD_DESPESA");
				String cpf = result.getString("T_USUARIO_NR_CPF");
				int tipo = result.getInt("T_TIPO_CD_TIPO");
				String descricao = result.getString("DS_DESPESA");
				double valor_despesa = result.getDouble("VL_DESPESA");
				java.sql.Date data = result.getDate("DT_DESPESA");
				Calendar data_despesa = Calendar.getInstance();
				data_despesa.setTimeInMillis(data.getTime());
				String recorrencia = result.getString("DS_RECORRENCIA");
				int qtd_repeticao = result.getInt("NR_QTD_REPETICAO");
				Despesa despesa = new Despesa(codigo, cpf, tipo, descricao, valor_despesa, data_despesa, recorrencia, qtd_repeticao);
				
				lista.add(despesa);
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
			String sql = "DELETE FROM T_DESPESA WHERE CD_DESPESA = ?";
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
	
	public Despesa buscaPorCD(int codigoBusca) {
		
		Despesa despesa = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESA WHERE CD_DESPESA = ?");
			stmt.setInt(1, codigoBusca);
			result = stmt.executeQuery();
			
			if(result.next()) {
				int codigo = result.getInt("CD_DESPESA");
				String cpf = result.getString("T_USUARIO_NR_CPF");
				int tipo = result.getInt("T_TIPO_CD_TIPO");
				String descricao = result.getString("DS_DESPESA");
				double valor_despesa = result.getDouble("VL_DESPESA");
				java.sql.Date data = result.getDate("DT_DESPESA");
				Calendar data_despesa = Calendar.getInstance();
				data_despesa.setTimeInMillis(data.getTime());
				String recorrencia = result.getString("DS_RECORRENCIA");
				int qtd_repeticao = result.getInt("NR_QTD_REPETICAO");
				despesa = new Despesa(codigo, cpf, tipo, descricao, valor_despesa, data_despesa, recorrencia, qtd_repeticao);
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
		return despesa;
	//System.out.println(funcionario.getCodigo()+ " " + funcionario.getNome() + " " + funcionario.getEmail() + " " + funcionario.getSalario() + " " + funcionario.getDataContratacao().getTime());

	}
	
	public void atualizar(Despesa despesa) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_DESPESA SET DS_DESPESA = ?, VL_DESPESA = ?, DT_DESPESA =?, DS_RECORRENCIA = ?, NR_QTD_REPETICAO = ? WHERE CD_DESPESA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, despesa.getDescricao());
			stmt.setDouble(2, despesa.getValor_despesa());
			java.sql.Date data = new java.sql.Date(despesa.getData_despesa().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setString(4, despesa.getRecorrencia());
			stmt.setInt(5, despesa.getQtd_repeticao());
			stmt.setInt(6, despesa.getCodigo());
			
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


