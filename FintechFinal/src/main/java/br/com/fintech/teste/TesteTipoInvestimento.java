package br.com.fintech.teste;


import java.util.List;

import br.com.fintech.bean.TipoInvestimento;
import br.com.fintech.dao.TipoInvestimentoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;

public class TesteTipoInvestimento{
	
	public static void main(String[] args) {
		
		TipoInvestimentoDAO dao = DAOFactory.getTipoInvestimentoDAO();
		
		TipoInvestimento poupanca = new TipoInvestimento(0, 104, "POUPANCA");
		
		try {
			dao.cadastrar(poupanca);
			System.out.println("Cadastrado com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			
		}
		
		TipoInvestimento cdb = new TipoInvestimento(0, 10, "CDB-DI");
		
		try {
			dao.cadastrar(cdb);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		List<TipoInvestimento> lista = dao.listar();
			for(TipoInvestimento item: lista) {
				System.err.println(item.getCdTipoInvestimento() + " " + item.getNumeroBanco() + " "
						+ item.getDescricaoInvestimento());
			}
		

		//Remover um registro
		try {
			dao.remover(50);
			System.out.println("Removido com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			}
		
		
		//Consultando e alterando um registro
		TipoInvestimento tpInvest = new TipoInvestimento();
		tpInvest = dao.buscaPorCodigo(70);
		tpInvest.setNumeroBanco(104);
		
		try {
			dao.atualizar(tpInvest);
			System.err.println("Atualizado com sucesso.");
		} catch (DBException e) {
			e.printStackTrace();
			}
	}
	

}
