package br.com.lobasoftworks.trabalhoia.estruturas;

public class No {
	private No noPai;
	private Estado estado;
	private Acao acao;
	private double distancia;
	private int profundidade;
	
	public No() {
		super();
		// TODO Auto-generated constructor stub
	}

	public No(No noPai, Estado estado, Acao acao, double distancia, int profundidade) {
		super();
		this.noPai = noPai;
		this.estado = estado;
		this.acao = acao;
		this.distancia = distancia;
		this.profundidade = profundidade;
	}

	public No getNoPai() {
		return noPai;
	}

	public void setNoPai(No noPai) {
		this.noPai = noPai;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}
}
