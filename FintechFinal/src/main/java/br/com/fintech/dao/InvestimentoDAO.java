package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Investimento;
import br.com.fintech.exception.DBException;

public interface InvestimentoDAO {
	
	public void cadastrar(Investimento investimento) throws DBException;
	
	public void atualizar(Investimento investimento) throws DBException;
	
	public void remover(int codigo) throws DBException;
	
	public Investimento buscaPorCodigo(int codigoBusca);
	
	public List<Investimento> listar();
	
	

	

}
