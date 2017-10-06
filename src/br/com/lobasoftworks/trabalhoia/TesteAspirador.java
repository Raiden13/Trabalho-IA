package br.com.lobasoftworks.trabalhoia;

import br.com.lobasoftworks.trabalhoia.aspirador.Aspira;
import br.com.lobasoftworks.trabalhoia.aspirador.Aspirador;
import br.com.lobasoftworks.trabalhoia.aspirador.Direita;
import br.com.lobasoftworks.trabalhoia.aspirador.Esquerda;
import br.com.lobasoftworks.trabalhoia.aspirador.Profundidade;
import br.com.lobasoftworks.trabalhoia.aspirador.Situacao;
import br.com.lobasoftworks.trabalhoia.estruturas.Acao;
import br.com.lobasoftworks.trabalhoia.estruturas.Problema;
import br.com.lobasoftworks.trabalhoia.estruturas.Resolvedor;

public class TesteAspirador {

	public static void main(String[] args) {
		Aspirador aspirador;
		Problema problema;
		Resolvedor r;
		
		aspirador = new Aspirador(new Situacao[] {Situacao.SUJO, Situacao.LIMPO}, 1);
		problema = new Problema(aspirador);
		
		for (Acao a : new Acao[] {new Direita(), new Esquerda(), new Aspira()})
			problema.add(a);
		
		r = new Resolvedor(new Profundidade(), problema);
		
		System.out.println("--- Solucao ---");
		
		for (String s : r.busca())
			System.out.println(s);
		
		System.out.println("---------------");
		System.out.println("Nos: " + r.getNos());
		System.out.println("Profundidade: " + r.getProfundidade());
	}
}
