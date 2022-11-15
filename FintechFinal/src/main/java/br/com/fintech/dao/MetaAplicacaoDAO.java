package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.MetaAplicacao;
import br.com.fintech.exception.DBException;

public interface MetaAplicacaoDAO {

	
	public void cadastrar(MetaAplicacao metaAplicacao) throws DBException;
	
	public void atualizar(MetaAplicacao metaAplicacao) throws DBException;
	
	public void remover(int codigo) throws DBException;
	
	public MetaAplicacao buscaPorCodigo(int codigoBusca);
	
	public List<MetaAplicacao> listar();
	
}
