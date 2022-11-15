package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Receita;


public interface ReceitaDAO {
	
	public void Cadastrar(Receita receita);
	
	public List <Receita> listar();
	
	public void remover(int codigo);
	
	public Receita buscaPorCD(int codigoBusca);
	
	public void atualizar(Receita receita);	

}
