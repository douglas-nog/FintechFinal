package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.TipoInvestimento;
import br.com.fintech.exception.DBException;


public interface TipoInvestimentoDAO {
	
	public void cadastrar(TipoInvestimento tipoInvestimento) throws DBException;
	
	public void atualizar(TipoInvestimento tipoInvestimento) throws DBException;
	
	public void remover(int codigo) throws DBException;
	
	public TipoInvestimento buscaPorCodigo(int codigoBusca);
	
	public List<TipoInvestimento> listar();

}
