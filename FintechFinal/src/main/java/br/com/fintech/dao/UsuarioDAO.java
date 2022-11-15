package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Usuario;

public interface UsuarioDAO {

public void Cadastrar(Usuario usuario);

	boolean validarUsuario(Usuario usuario);

	public List <Usuario> listar();
	
	public void remover(String cpf);
	
	public Usuario buscaPorCPF(String cpfBusca);
	
	public void atualizar(Usuario usuario);	

}
