package br.com.lobasoftworks.trabalhoia.estruturas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Resolvedor {
	private Estrategia estrategia;
	private Problema problema;
	private int nos;
	private int profundidade;
	private double custoCaminho;
	
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

	public int getProfundidade() {
		return profundidade;
	}

	public double getCustoCaminho() {
		return custoCaminho;
	}

	/**
	 * Resolve um problema pelo metodo da busca em arvore.
	 * @return os passos para resolver o problema, caso haja
	 * solucao.
	 */
	public String[] busca() {
		List<No> borda = estrategia.criaLista(); // criando a borda
		HashSet<Long> gerados = new HashSet<>(); // estados gerados
		No no;
		long id;
		
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
			id = no.getEstado().getId();
			// Diga que este estado ja foi gerado
			gerados.add(new Long(id));
			nos ++;
			profundidade = no.getProfundidade();
			
			// Se o estado atual for o estado objetivo, entao
			if (no.getEstado().eObjetivo()) {
				custoCaminho = no.getDistancia();
				
				// retorne a solucao do problema
				return solucao(no);
			}
			
			// Senao, expande o no e adiciona os seus sucessores a borda
			estrategia.adiciona(borda, expande(no, gerados));
		}
	}
	
	/**
	 * Expande um no e retorna a lista de nos sucessores, ou seja, os
	 * outros estados que podem ser alcancados a partir deste no.
	 * @param no no do estado atual do ambiente
	 * @param gerados lista dos estados gerados anteriormente
	 * @return a lista de estados sucessores do estado do no atual
	 */
	private List<No> expande(No no, HashSet<Long> gerados) {
		List<No> sucessores = estrategia.criaLista();
		Acao acao;
		Estado resultado;
		
		// Para cada (acao, sucessor) em sucessor(estado) faca
		for (Object[] ar : problema.sucessor(no.getEstado())) {
			acao = (Acao) ar[0];
			resultado = (Estado) ar[1];
			
			// Se o estado ainda nao foi gerado anteriormente, entao
			if (!gerados.contains(new Long(resultado.getId()))) {
				// adicione ele a lista de sucessores
				sucessores.add(new No(no, resultado, acao,
						resultado.distancia(no.getEstado()) +
						no.getDistancia(),
						1 + no.getProfundidade()));
				// informa que este estado ja foi gerado anteriormente
				gerados.add(resultado.getId()); // <-- depois ver se isto
				// pode eliminar a solucao otima do problema
			}
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
			passos.add(0, noAtual.getAcao().getNome() + " g(n): " + noAtual.getDistancia() + 
					" h(n): " + noAtual.getEstado().heuristica());
			noAtual = noAtual.getNoPai();
		}
		
		passos.add(0, "Estado inicial g(n): " + noAtual.getDistancia() + " h(n): " + noAtual.getEstado().heuristica());
		
		s = new String[passos.size()];
		
		for (i = 0; i < s.length; i ++)
			s[i] = passos.get(i);
		
		return s;
	}
}
