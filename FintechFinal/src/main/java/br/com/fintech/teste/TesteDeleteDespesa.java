package br.com.fintech.teste;

import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.factory.DAOFactory;

public class TesteDeleteDespesa {

	public static void main(String[] args) {


		DespesaDAO dao = DAOFactory.getDespesaDAO();
		
		//Deletando a despesa: "41	05687412300	20	BARZINHO	100	26/10/22		0"
		
		try {
			
			dao.remover(41);
			System.out.println("Removido!");
			
		}catch(Exception e){
			e.printStackTrace();
			
		}

	}

}
