package br.com.fintech.teste;

import br.com.fintech.bean.Despesa;
import br.com.fintech.dao.impl.OracleDespesaDAO;

public class TesteAlteracaoDespesa {

	public static void main(String[] args) {
		
		OracleDespesaDAO dao = new OracleDespesaDAO();
		
		
		//Corrigindo valor da despesa de aluguel cadastrada como R$100 ao invés de R$1000
		Despesa despesa = dao.buscaPorCD(25);
		
		despesa.setValor_despesa(1000);
		
		dao.atualizar(despesa);
		

	}

}
