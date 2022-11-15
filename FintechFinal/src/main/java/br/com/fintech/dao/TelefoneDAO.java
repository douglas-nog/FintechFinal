package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Telefone;
import br.com.fintech.exception.DBException;

public interface TelefoneDAO {
		
	public void cadastrar(Telefone telefone) throws DBException;
	
	public void atualizar(Telefone telefone) throws DBException;
	
	public void remover(int codigo) throws DBException;
	
	public Telefone buscaPorCodigo(int codigoBusca);
	
	public List<Telefone> listar();
}
