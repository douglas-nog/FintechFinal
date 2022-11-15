package br.com.fintech.teste;

import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.factory.DAOFactory;

public class TesteAlteracaoUsuario {

	public static void main(String[] args) {


		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		Usuario usuario = new Usuario();
		
		usuario = dao.buscaPorCPF("07855659900");
		
		usuario.setNome("DOUGLAS");
		usuario.setSobrenome("NOGUEIRA");
		usuario.setSenha("123456abc");
		
		try{
			dao.atualizar(usuario);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		
		//Alterando usuário com nome errado 
//		Usuario usuarioErrado = dao.buscaPorCPF("05689756400");
//		
//		usuarioErrado.setNome("AIRTON");
//		usuarioErrado.setSobrenome("SILVA");
//		usuarioErrado.setSenha("5614zds4s5d4");
//
//		try {
//			dao.atualizar(usuarioErrado);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
	}
	
}
