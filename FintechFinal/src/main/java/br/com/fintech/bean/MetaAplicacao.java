package br.com.fintech.bean;

import java.util.Calendar;

public class MetaAplicacao {
	
	private int codigoMeta;
	private int codigoInvestimento;
	private String cpf;
	private Calendar dataCriacao;
	private Calendar dataFinal;
	private double valorMeta;
	
	public MetaAplicacao(int codigoMeta, int codigoInvestimento, String cpf, Calendar dataCriacao, Calendar dataFinal,
			double valorMeta) {
		super();
		this.codigoMeta = codigoMeta;
		this.codigoInvestimento = codigoInvestimento;
		this.cpf = cpf;
		this.dataCriacao = dataCriacao;
		this.dataFinal = dataFinal;
		this.valorMeta = valorMeta;
	}

	public MetaAplicacao() {
		super();
	}

	public int getCodigoMeta() {
		return codigoMeta;
	}

	public void setCodigoMeta(int codigoMeta) {
		this.codigoMeta = codigoMeta;
	}

	public int getCodigoInvestimento() {
		return codigoInvestimento;
	}

	public void setCodigoInvestimento(int codigoInvestimento) {
		this.codigoInvestimento = codigoInvestimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}
	
	
	
	

}
