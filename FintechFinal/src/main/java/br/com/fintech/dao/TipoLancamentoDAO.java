package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.TipoLancamento;
import br.com.fintech.exception.DBException;

public interface TipoLancamentoDAO {
	
public void cadastrar(TipoLancamento tipoLancamento) throws DBException;
	
	public void atualizar(TipoLancamento tipoLancamento) throws DBException;
	
	public void remover(int codigo) throws DBException;
	
	public TipoLancamento buscaPorCodigo(int codigoBusca);
	
	public List<TipoLancamento> listar();


}
