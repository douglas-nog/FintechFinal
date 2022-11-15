package br.com.fintech.teste;

import java.util.List;

import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.factory.DAOFactory;

public class TesteListagemUsuario {

	public static void main(String[] args) {
		
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		List<Usuario> lista = dao.listar();
		for(Usuario item : lista) {
			System.err.println(item.getCpf() + " " + item.getNome() + " " + item.getSobrenome() + " " +
					item.getEmail());
		}

	}

}
