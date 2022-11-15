package br.com.fintech.bean;

public class TipoLancamento {
	
	private int codigoTipoLancamento;
	private String descricaoLancamento;
	
	public TipoLancamento(int codigoTipoLancamento, String descricaoLancamento) {
		super();
		this.codigoTipoLancamento = codigoTipoLancamento;
		this.descricaoLancamento = descricaoLancamento;
	}

	public TipoLancamento() {
		super();
	}

	public int getCodigoTipoLancamento() {
		return codigoTipoLancamento;
	}

	public void setCodigoTipoLancamento(int codigoTipoLancamento) {
		this.codigoTipoLancamento = codigoTipoLancamento;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}
	
	
}
