package br.com.fintech.teste;


import java.util.Calendar;
import java.util.List;

import br.com.fintech.bean.Investimento;
import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;

public class TesteInvestimento {
	
	public static void main(String[] args) {
		
		InvestimentoDAO dao = DAOFactory.getInvestimentoDAO();
		
		//Cadastrar registros
		Investimento investimento1 = new Investimento();
		
		investimento1.setCpf("08965474220");
		investimento1.setTipoInvestimento(20);
		investimento1.setDataInvestimento(Calendar.getInstance());
		investimento1.setValorInvestimento(1000);
		
		try {
			dao.cadastrar(investimento1);
			System.out.println("Cadastrado com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		Investimento investimento2 = new Investimento(0, "08965474220", 80, Calendar.getInstance(), 1400);
		
		try {
			dao.cadastrar(investimento2);
			System.out.println("Cadastrado com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		Investimento investimento3 = new Investimento(0, "05687412300", 20, Calendar.getInstance(), 2000);
		
		try {
			dao.cadastrar(investimento3);
			System.out.println("Cadastrado com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Remover registro
		try {
			dao.remover(5);
			System.out.println("Removido com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Listar registros
		List<Investimento> lista = dao.listar();
			for(Investimento item: lista) {
				System.err.println(item.getCodigo() + " " + item.getCpf() + " " + item.getTipoInvestimento()
				+ " " + item.getDataInvestimento().getTime() + " " + item.getValorInvestimento());
			}
		
		//Buscar e alterar registro 
		
		Investimento invest = new Investimento();
		invest = dao.buscaPorCodigo(3);
		invest.setValorInvestimento(5984);
		
		try {
			dao.atualizar(invest);
			System.err.println("Atualizado com sucesso!");			
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
