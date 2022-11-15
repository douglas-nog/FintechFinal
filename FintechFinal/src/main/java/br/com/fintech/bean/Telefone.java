package br.com.fintech.bean;

public class Telefone {
	
	private int codigoTelefone;
	private String cpf;
	private int tipoTelefone;
	private String ddd;
	private String numeroTelefone;
	
	
	
	public Telefone(int codigoTelefone, String cpf, int tipoTelefone, String ddd, String numeroTelefone) {
		super();
		this.codigoTelefone = codigoTelefone;
		this.cpf = cpf;
		this.tipoTelefone = tipoTelefone;
		this.ddd = ddd;
		this.numeroTelefone = numeroTelefone;
	}

	public Telefone() {
		super();
	}

	public int getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(int codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(int tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	

}
