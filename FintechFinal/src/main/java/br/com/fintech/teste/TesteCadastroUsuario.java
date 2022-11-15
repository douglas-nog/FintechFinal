package br.com.fintech.teste;

import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.impl.OracleUsuarioDAO;

public class TesteCadastroUsuario {
	
	
	public static void main(String[] args) {
		
	OracleUsuarioDAO dao = new OracleUsuarioDAO();
	
//	Usuario usuario1 = new Usuario();
	
//	usuario1.setCpf("05689756400");
//	usuario1.setNome("Ayrton");
//	usuario1.setSobrenome("Cabral");
//	usuario1.setEmail("ayrtoncabral@hotmail.com");
//	usuario1.setSenha("123abc");
//	
//	dao.Cadastrar(usuario1);
//	
//
//	Usuario usuario2 = new Usuario();
//	
//	usuario2.setCpf("08965474220");
//	usuario2.setNome("KLÉBER");
//	usuario2.setSobrenome("PEREIRA");
//	usuario2.setSenha("789456");
//	usuario2.setEmail("kpereira@gmail.com");
//	
//	dao.Cadastrar(usuario2);
	
	//cadastrando usuário com nome errado
	Usuario usuario3 = new Usuario();
	
	usuario3.setCpf("05687412300");
	usuario3.setNome("ANDÉ");
	usuario3.setSobrenome("SAMPAIO");
	usuario3.setEmail("andresamp@hotmail.com");
	usuario3.setSenha("H*7897");
	
	dao.Cadastrar(usuario3);
	
	}
	
	

}
