package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Despesa;
import br.com.fintech.exception.DBException;

public interface DespesaDAO {
	
	public void Cadastrar(Despesa despesa) throws DBException;
	
	public List <Despesa> listar();
	
	public void remover(int codigo) throws DBException;
	
	public Despesa buscaPorCD(int codigoBusca);
	
	public void atualizar(Despesa despesa) throws DBException;	

}
