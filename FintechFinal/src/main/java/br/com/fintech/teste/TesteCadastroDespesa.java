package br.com.fintech.teste;

import java.util.Calendar;

import br.com.fintech.bean.Despesa;
import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.factory.DAOFactory;

public class TesteCadastroDespesa {

	public static void main(String[] args) {
		
		DespesaDAO dao = DAOFactory.getDespesaDAO();
		
//		Despesa despesa1 = new Despesa();
//		
//		despesa1.setCpf("08965474220");
//		despesa1.setValor_despesa(150);
//		despesa1.setDescricao("RESTAURANTE");
//		despesa1.setData_despesa(Calendar.getInstance());
//		despesa1.setTipo(10);
//		
//		dao.Cadastrar(despesa1);
		
		
//		Despesa despesa2 = new Despesa();
//		
//		despesa2.setCpf("05687412300");
//		despesa2.setDescricao("COMPRA LOJA X");
//		despesa2.setValor_despesa(200);
//		despesa2.setTipo(30);
//		despesa2.setData_despesa(Calendar.getInstance());
//		despesa2.setRecorrencia("MENSAL");
//		despesa2.setQtd_repeticao(3);
//		
//		dao.Cadastrar(despesa2);
		
//		Despesa despesa3 = new Despesa();
//		
//		despesa3.setCpf("07855659900");
//		despesa3.setDescricao("CINEMA");
//		despesa3.setValor_despesa(40);
//		despesa3.setTipo(20);
//		despesa3.setData_despesa(Calendar.getInstance());
//		
//		dao.Cadastrar(despesa3);
		
//		Despesa despesa4 = new Despesa();
//		
//		despesa4.setCpf("05689756400");
//		despesa4.setDescricao("INTERNET");
//		despesa4.setValor_despesa(149.90);
//		despesa4.setTipo(10);
//		despesa4.setData_despesa(Calendar.getInstance());
//		despesa4.setRecorrencia("MENSAL");
//		despesa4.setQtd_repeticao(12);
//		
//		dao.Cadastrar(despesa4);
		
		//Cadastrando despesa com valor incorreto para testar "UPDATE"
		
//		Despesa despesa5 = new Despesa();
//		
//		despesa5.setCpf("05687412300");
//		despesa5.setDescricao("ALUGUEL");
//		despesa5.setValor_despesa(100);
//		despesa5.setTipo(10);
//		despesa5.setData_despesa(Calendar.getInstance());
//		despesa5.setRecorrencia("MENSAL");
//		despesa5.setQtd_repeticao(12);
//		
//		dao.Cadastrar(despesa5);
//		
		//Essa despesa será deletada para destador o "DELETE"
		Despesa despesa6 = new Despesa();
		
		despesa6.setCpf("05687412300");
		despesa6.setDescricao("BARZINHO");
		despesa6.setValor_despesa(100);
		despesa6.setTipo(20);
		despesa6.setData_despesa(Calendar.getInstance());
		
		
		try {
			dao.Cadastrar(despesa6);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
