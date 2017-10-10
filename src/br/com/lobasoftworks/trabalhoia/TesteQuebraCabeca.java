package br.com.lobasoftworks.trabalhoia;

import br.com.lobasoftworks.trabalhoia.estrategiasdebusca.AEstrela;
import br.com.lobasoftworks.trabalhoia.estruturas.Acao;
import br.com.lobasoftworks.trabalhoia.estruturas.Problema;
import br.com.lobasoftworks.trabalhoia.estruturas.Resolvedor;
import br.com.lobasoftworks.trabalhoia.puzzle.Baixo;
import br.com.lobasoftworks.trabalhoia.puzzle.Cima;
import br.com.lobasoftworks.trabalhoia.puzzle.Direita;
import br.com.lobasoftworks.trabalhoia.puzzle.Esquerda;
import br.com.lobasoftworks.trabalhoia.puzzle.H2;
import br.com.lobasoftworks.trabalhoia.puzzle.Heuristica;
import br.com.lobasoftworks.trabalhoia.puzzle.Tabuleiro;

public class TesteQuebraCabeca {

	public static void main(String[] args) {
		int[][] pecas = new int[][] {{4, 0, 7}, {5, 2, 6}, {3, 8, 1}};
		Heuristica h = new H2();
		Tabuleiro estadoInicial;
		Problema problema = new Problema();
		Resolvedor r;
		
		estadoInicial = new Tabuleiro(pecas, h);
		problema.setEstadoInicial(estadoInicial);
		
		for (Acao a : new Acao[] {new Direita(), new Esquerda(), new Cima(), new Baixo()})
			problema.add(a);
		
		r = new Resolvedor(new AEstrela(), problema);
		
		System.out.println("--- Solucao ---");
		
		for (String s : r.busca())
			System.out.println(s);
		
		System.out.println("---------------");
		System.out.println("Nos: " + r.getNos());
		System.out.println("Profundidade: " + r.getProfundidade());
		System.out.println("Custo do caminho: " + r.getCustoCaminho());
	}
}
