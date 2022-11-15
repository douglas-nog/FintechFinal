package br.com.fintech.teste;


import br.com.fintech.bean.Receita;
import br.com.fintech.dao.impl.OracleReceitaDAO;

public class TesteAlteracaoReceita {

	public static void main(String[] args) {
		
		//Atualizando a receita cd = 23: 
		OracleReceitaDAO dao = new OracleReceitaDAO();
		
		Receita receita1 = dao.buscaPorCD(25);
		
		System.out.println(receita1.getCodigo() + " " + receita1.getCpf() + " " + receita1.getTipo() + " " +
				receita1.getDescricao() + " " + receita1.getData_receita().getTime() + " " + receita1.getValor_receita() + " " +
				receita1.getRecorrencia() + " " + receita1.getQtd_repeticao());
		
		receita1.setValor_receita(5000.50);
		
		
		dao.atualizar(receita1);

	}

}
