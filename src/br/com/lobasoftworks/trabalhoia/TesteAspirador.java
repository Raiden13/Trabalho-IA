package br.com.lobasoftworks.trabalhoia;

import br.com.lobasoftworks.trabalhoia.aspirador.Aspira;
import br.com.lobasoftworks.trabalhoia.aspirador.Aspirador;
import br.com.lobasoftworks.trabalhoia.aspirador.Direita;
import br.com.lobasoftworks.trabalhoia.aspirador.Esquerda;
import br.com.lobasoftworks.trabalhoia.aspirador.Situacao;
import br.com.lobasoftworks.trabalhoia.estrategiasdebusca.AEstrela;
import br.com.lobasoftworks.trabalhoia.estruturas.Acao;
import br.com.lobasoftworks.trabalhoia.estruturas.Problema;
import br.com.lobasoftworks.trabalhoia.estruturas.Resolvedor;

public class TesteAspirador {

	public static void main(String[] args) {
		Aspirador estadoInicial = new Aspirador();
		Problema problema = new Problema();
		Resolvedor r = new Resolvedor();
		
		estadoInicial.setComodo(0, Situacao.SUJO);
		estadoInicial.setComodo(1, Situacao.SUJO);
		estadoInicial.setPosicao(0);
		problema.setEstadoInicial(estadoInicial);
		
		for (Acao a : new Acao[] {new Aspira(), new Direita(), new Esquerda()})
			problema.add(a);
		
		r.setProblema(problema);
		r.setEstrategia(new AEstrela());
		
		System.out.println("--- Solucao ---");
		
		for (String s : r.busca())
			System.out.println(s);
		
		System.out.println("---------------");
		System.out.println("Nos: " + r.getNos());
		System.out.println("Profundidade: " + r.getProfundidade());
		System.out.println("Custo: " + r.getCustoCaminho());
	}
}
