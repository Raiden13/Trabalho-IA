package br.com.lobasoftworks.trabalhoia.estruturas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Resolvedor {
	private Estrategia estrategia;
	private Problema problema;
	private int nos;
	private int profundidade;
	
	public Resolvedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resolvedor(Estrategia estrategia, Problema problema) {
		super();
		this.estrategia = estrategia;
		this.problema = problema;
	}

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public Problema getProblema() {
		return problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}
	
	public int getNos() {
		return nos;
	}

	public void setNos(int nos) {
		this.nos = nos;
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	/**
	 * Expande um no e retorna a lista de nos sucessores, ou seja, os
	 * outros estados que podem ser alcancados a partir deste no.
	 * @param no no do estado atual do ambiente
	 * @param gerados lista dos estados gerados anteriormente
	 * @return a lista de estados sucessores do estado do no atual
	 */
	private List<No> expande(No no, Collection<Long> gerados) {
		List<No> sucessores = estrategia.criaLista();
		Acao acao;
		Estado resultado;
		
		// Para cada (acao, sucessor) em sucessor(estado) faca
		for (Object[] ar : problema.sucessor(no.getEstado())) {
			acao = (Acao) ar[0];
			resultado = (Estado) ar[1];
			
			// Se o estado ainda nao foi gerado anteriormente, entao
			if (!gerados.contains(resultado.getId()))
				// adicione ele a lista de sucessores
				sucessores.add(new No(no, resultado, acao,
						resultado.distancia(no.getEstado()) +
						resultado.heuristica() + no.getDistancia(),
						1 + no.getProfundidade()));
		}
		
		return sucessores;
	}
	
	/**
	 * @param no no folha da arvore de buscas
	 * @return um vetor de strings contendo os passos para resolver
	 * um determinado problema.
	 */
	private String[] solucao(No no) {
		List<String> passos = new ArrayList<String>();
		String[] s;
		No noAtual = no;
		int i;
		
		while (noAtual.getAcao() != null) {
			passos.add(0, noAtual.getAcao().getNome());
			noAtual = noAtual.getNoPai();
		}
		
		s = new String[passos.size()];
		
		for (i = 0; i < s.length; i ++)
			s[i] = passos.get(i);
		
		return s;
	}
	
	/**
	 * Resolve um problema pelo metodo da busca em arvore.
	 * @return os passos para resolver o problema, caso haja
	 * solucao.
	 */
	public String[] busca() {
		List<No> borda = estrategia.criaLista(); // criando a borda
		Collection<Long> gerados = new HashSet<>(); // estados gerados
		No no;
		
		// Adiciona o no do estado inicial a borda
		borda.add(new No(null, problema.getEstadoInicial(), null, 0, 0));
		nos = 0;
		profundidade = 0;
		
		while (true) {
			// Se a borda for vazia, entao retorna fracasso
			if (borda.isEmpty())
				
				return new String[] {};
			
			// Remove o primeiro no da borda
			no = borda.remove(0);
			// Diga que este estado ja foi gerado
			gerados.add(no.getEstado().getId());
			nos ++;
			profundidade = no.getProfundidade();
			
			// Se o estado atual for o estado objetivo, entao
			if (no.getEstado().eObjetivo())
				// retorne a solucao do problema
				return solucao(no);
			
			// Senao, expande o no e adiciona os seus sucessores a borda
			estrategia.adiciona(borda, expande(no, gerados));
		}
	}
}
