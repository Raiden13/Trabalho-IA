package br.com.lobasoftworks.trabalhoia.estruturas;

public abstract class Acao {
	private String nome;

	public Acao(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Executa a acao e altera o estado do ambiente.
	 * @param estado estado atual do ambiente.
	 * @return novo estado do ambiente.
	 */
	public abstract Estado executa(Estado estado);
}
