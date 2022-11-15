package br.com.fintech.factory;

import br.com.fintech.dao.*;
import br.com.fintech.dao.impl.*;

public class DAOFactory {

	public static ReceitaDAO getReceitaDAO() {
		return new OracleReceitaDAO();
	}
	
	public static DespesaDAO getDespesaDAO() {
		return new OracleDespesaDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}
	
	public static TipoInvestimentoDAO getTipoInvestimentoDAO() {
		return new OracleTipoInvestimentoDAO();
	}
}
