package br.com.lobasoftworks.trabalhoia.aspirador;

import br.com.lobasoftworks.trabalhoia.estruturas.Acao;
import br.com.lobasoftworks.trabalhoia.estruturas.Estado;

public class Direita extends Acao {

	public Direita() {
		super("Direita");
	}
	
	@Override
	public Estado executa(Estado estado) {
		// TODO Auto-generated method stub
		Aspirador atual, novoEstado;
		
		atual = (Aspirador) estado;
		novoEstado = new Aspirador(new Situacao[] {atual.getComodo(0),
				atual.getComodo(1)}, 1);
		
		return novoEstado;
	}
}
