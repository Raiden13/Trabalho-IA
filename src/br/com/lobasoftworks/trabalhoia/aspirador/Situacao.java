package br.com.lobasoftworks.trabalhoia.aspirador;

public enum Situacao {
	LIMPO(true),
	SUJO(false);
	
	private boolean situacao;
	
	Situacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	public boolean getSituacao() {
		return situacao;
	}
}
