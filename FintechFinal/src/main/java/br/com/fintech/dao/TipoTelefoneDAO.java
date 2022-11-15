package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.TipoTelefone;
import br.com.fintech.exception.DBException;

public interface TipoTelefoneDAO {
	
public void cadastrar(TipoTelefone tipoTelefone) throws DBException;
	
	public void atualizar(TipoTelefone tipoTelefone) throws DBException;
	
	public void remover(int codigo) throws DBException;
	
	public TipoTelefone buscaPorCodigo(int codigoBusca);
	
	public List<TipoTelefone> listar();
	

}
