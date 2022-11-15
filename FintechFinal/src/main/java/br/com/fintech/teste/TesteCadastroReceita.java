package br.com.fintech.teste;

import java.util.Calendar;

import br.com.fintech.bean.Receita;
import br.com.fintech.dao.impl.OracleReceitaDAO;

public class TesteCadastroReceita {

	public static void main(String[] args) {

		//Cadastrando receita salário sem valor:
		OracleReceitaDAO dao = new OracleReceitaDAO();
		
//		Receita receita1 = new Receita();
		
//		receita1.setDescricao("SALÁRIO");
//		receita1.setData_receita(Calendar.getInstance());
//		receita1.setCpf("07855659900");
//		receita1.setTipo(10);
//		receita1.setRecorrencia("MENSAL");
//		receita1.setQtd_repeticao(6);
//		
//		dao.Cadastrar(receita1);
		
		
		//Cadastrando uma receita variável
//		Receita receita2 = new Receita();
		
//		receita2.setCpf("07855659900");
//		receita2.setDescricao("VENDA DE VIDEO GAME");
//		receita2.setValor_receita(1000);
//		receita2.setTipo(20);
//		receita2.setData_receita(Calendar.getInstance());
//		
//		dao.Cadastrar(receita2);
		
		Receita receita3 = new Receita();
		
		receita3.setCpf("05689756400");
		receita3.setDescricao("PROJETO ABC");
		receita3.setData_receita(Calendar.getInstance());
		receita3.setTipo(20);
		receita3.setValor_receita(1500);
		
		dao.Cadastrar(receita3);
	}

}
