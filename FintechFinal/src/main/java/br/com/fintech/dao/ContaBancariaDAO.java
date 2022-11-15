package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.ContaBancaria;
import br.com.fintech.exception.DBException;

public interface ContaBancariaDAO {

	
public void cadastrar(ContaBancaria contaBancaria) throws DBException;
	
	public void atualizar(ContaBancaria contaBancaria) throws DBException;
	
	public void remover(int codigo) throws DBException;
	
	public ContaBancaria buscaPorCodigo(int codigoBusca);
	
	public List<ContaBancaria> listar();
}
