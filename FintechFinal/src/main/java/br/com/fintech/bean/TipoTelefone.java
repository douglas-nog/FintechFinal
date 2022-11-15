package br.com.fintech.bean;

public class TipoTelefone {
	
	private int codigoTipoTelefone;
	private String DescricaoTipoTelefone;
	
	public TipoTelefone(int codigoTipoTelefone, String descricaoTipoTelefone) {
		super();
		this.codigoTipoTelefone = codigoTipoTelefone;
		DescricaoTipoTelefone = descricaoTipoTelefone;
	}

	public TipoTelefone() {
		super();
	}

	public int getCodigoTipoTelefone() {
		return codigoTipoTelefone;
	}

	public void setCodigoTipoTelefone(int codigoTipoTelefone) {
		this.codigoTipoTelefone = codigoTipoTelefone;
	}

	public String getDescricaoTipoTelefone() {
		return DescricaoTipoTelefone;
	}

	public void setDescricaoTipoTelefone(String descricaoTipoTelefone) {
		DescricaoTipoTelefone = descricaoTipoTelefone;
	}
	
}
