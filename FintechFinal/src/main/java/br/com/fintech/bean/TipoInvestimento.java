package br.com.fintech.bean;

public class TipoInvestimento {
	
	private int cdTipoInvestimento;
	
	private int numeroBanco;
	
	private String descricaoInvestimento;

	public TipoInvestimento(int cdTipoInvestimento, int numeroBanco, String descricaoInvestimento) {
		super();
		this.cdTipoInvestimento = cdTipoInvestimento;
		this.numeroBanco = numeroBanco;
		this.descricaoInvestimento = descricaoInvestimento;
	}

	public TipoInvestimento() {
		super();
	}

	public int getCdTipoInvestimento() {
		return cdTipoInvestimento;
	}

	public void setCdTipoInvestimento(int cdTipoInvestimento) {
		this.cdTipoInvestimento = cdTipoInvestimento;
	}

	public int getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(int numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public String getDescricaoInvestimento() {
		return descricaoInvestimento;
	}

	public void setDescricaoInvestimento(String descricaoInvestimento) {
		this.descricaoInvestimento = descricaoInvestimento;
	}
	
	

}
