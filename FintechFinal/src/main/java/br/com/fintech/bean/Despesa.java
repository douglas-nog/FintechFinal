package br.com.fintech.bean;

import java.util.Calendar;

public class Despesa {
	
	private int codigo;
	private String cpf;
	private int tipo;
	private String descricao;
    private double valor_despesa;
    private Calendar data_despesa;
    private String recorrencia;
    private int qtd_repeticao;
    
	public Despesa() {
		super();
	}

	public Despesa(int codigo, String cpf, int tipo, String descricao, double valor_despesa, Calendar data_despesa,
			String recorrencia, int qtd_repeticao) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor_despesa = valor_despesa;
		this.data_despesa = data_despesa;
		this.recorrencia = recorrencia;
		this.qtd_repeticao = qtd_repeticao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor_despesa() {
		return valor_despesa;
	}

	public void setValor_despesa(double valor_despesa) {
		this.valor_despesa = valor_despesa;
	}

	public Calendar getData_despesa() {
		return data_despesa;
	}

	public void setData_despesa(Calendar data_despesa) {
		this.data_despesa = data_despesa;
	}

	public String getRecorrencia() {
		return recorrencia;
	}

	public void setRecorrencia(String recorrencia) {
		this.recorrencia = recorrencia;
	}

	public int getQtd_repeticao() {
		return qtd_repeticao;
	}

	public void setQtd_repeticao(int qtd_repeticao) {
		this.qtd_repeticao = qtd_repeticao;
	} 

}
