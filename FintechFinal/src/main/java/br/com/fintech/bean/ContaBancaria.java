package br.com.fintech.bean;

public class ContaBancaria {
	
	private int codigoContaBancaria;
	private String cpf;
	private int codigoBanco;
	private int numeroAgencia;
	private int numeroConta;
	
	public ContaBancaria(int codigoContaBancaria, String cpf, int codigoBanco, int numeroAgencia, int numeroConta) {
		super();
		this.codigoContaBancaria = codigoContaBancaria;
		this.cpf = cpf;
		this.codigoBanco = codigoBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
	}

	public ContaBancaria() {
		super();
	}

	public int getCodigoContaBancaria() {
		return codigoContaBancaria;
	}

	public void setCodigoContaBancaria(int codigoContaBancaria) {
		this.codigoContaBancaria = codigoContaBancaria;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(int codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	
	
	

}
