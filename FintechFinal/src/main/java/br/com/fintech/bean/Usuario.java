package br.com.fintech.bean;

import br.com.fintech.util.CriptografiaUtils;

public class Usuario {
	
	private String cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
		
	public Usuario() {
		super();
	}
	
	

	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}



	public Usuario(String cpf, String nome, String sobrenome, String email, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	}
