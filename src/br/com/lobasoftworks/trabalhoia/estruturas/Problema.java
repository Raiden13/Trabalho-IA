package br.com.lobasoftworks.trabalhoia.estruturas;

import java.util.ArrayList;
import java.util.List;

public class Problema {
	private List<Acao> acoes;
	private Estado estadoInicial;
	
	public Problema(Estado estadoInicial) {
		super();
		this.acoes = new ArrayList<Acao>();;
		this.estadoInicial = estadoInicial;
	}

	public Problema() {
		super();
		// TODO Auto-generated constructor stub
		this.acoes = new ArrayList<Acao>();
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public List<Acao> getAcoes() {
		return acoes;
	}
	
	/**
	 * Aplica as acoes e retorna uma lista de sucessores de um
	 * determinado estado.
	 * @param estado estado atual do ambiente
	 * @return uma lista de pares (acao, sucessor) onde sucessor
	 * eh um sucessor do estado atual gerado pela acao. 
	 */
	public List<Object[]> sucessor(Estado estado) {
		ArrayList<Object[]> sucessores = new ArrayList<>();
		
		for (Acao acao : acoes)
			sucessores.add(new Object[] {acao, acao.executa(estado)});
		
		return sucessores;
	}
	
	/**
	 * Informa uma acao valida que o agente pode executar.
	 * @param acao acao valida para o agente.
	 */
	public void add(Acao acao) {
		acoes.add(acao);
	}
	
	/**
	 * Limpa a lista de acoes do agente.
	 */
	public void clear() {
		acoes.clear();
	}
}
