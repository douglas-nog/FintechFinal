package br.com.fintech.teste;

import java.util.List;

import br.com.fintech.bean.Receita;
import br.com.fintech.dao.impl.OracleReceitaDAO;

public class TesteListagemReceita {

	public static void main(String[] args) {
		
		OracleReceitaDAO dao = new OracleReceitaDAO();
		
		List<Receita> lista = dao.listar();
		for(Receita item: lista) {
			System.err.println(item.getCodigo() + " " + item.getCpf() + " " + item.getTipo() + " " +
					item.getDescricao()+ " " + item.getData_receita().getTime() + " " + item.getValor_receita() + " " +
					item.getRecorrencia() + " " + item.getQtd_repeticao());
		}
	}
	
}
