package br.com.lobasoftworks.trabalhoia;

import br.com.lobasoftworks.trabalhoia.estruturas.Acao;
import br.com.lobasoftworks.trabalhoia.estruturas.Problema;
import br.com.lobasoftworks.trabalhoia.estruturas.Resolvedor;
import br.com.lobasoftworks.trabalhoia.puzzle.AEstrela;
import br.com.lobasoftworks.trabalhoia.puzzle.Baixo;
import br.com.lobasoftworks.trabalhoia.puzzle.Cima;
import br.com.lobasoftworks.trabalhoia.puzzle.Direita;
import br.com.lobasoftworks.trabalhoia.puzzle.Esquerda;
import br.com.lobasoftworks.trabalhoia.puzzle.H2;
import br.com.lobasoftworks.trabalhoia.puzzle.Heuristica;
import br.com.lobasoftworks.trabalhoia.puzzle.Tabuleiro;

public class TesteQuebraCabeca {

	public static void main(String[] args) {
		//int[][] pecas = {{5, 0, 2}, {6, 4, 7}, {8, 1, 3}};
		int[][] pecas = {{5, 0, 2}, {6, 7, 4}, {8, 1, 3}};
		Heuristica h = new H2();
		Tabuleiro t;
		Problema p;
		Resolvedor r;
		
		t = new Tabuleiro(pecas, h);
		p = new Problema(t);
		
		for (Acao a : new Acao[] {new Direita(), new Esquerda(), new Baixo(), 
				new Cima()})
			p.add(a);
		
		r = new Resolvedor(new AEstrela(), p);
		
		System.out.println("--- Solucao ---");
		
		for (String s : r.busca())
			System.out.println(s);
		
		System.out.println("---------------");
		System.out.println("Nos: " + r.getNos());
		System.out.print("Profundidade: " + r.getProfundidade());
	}
}
