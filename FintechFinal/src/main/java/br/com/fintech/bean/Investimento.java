package br.com.fintech.bean;

import java.util.Calendar;

public class Investimento {
	
	private int codigo;
	private String cpf;
	private int tipoInvestimento;
	private Calendar dataInvestimento;
	private double valorInvestimento;
	
	public Investimento(int codigo, String cpf, int tipoInvestimento, Calendar dataInvestimento,
			double valorInvestimento) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.tipoInvestimento = tipoInvestimento;
		this.dataInvestimento = dataInvestimento;
		this.valorInvestimento = valorInvestimento;
	}

	public Investimento() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(int tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public Calendar getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(Calendar dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}

	public double getValorInvestimento() {
		return valorInvestimento;
	}

	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}
	
	
	

}
