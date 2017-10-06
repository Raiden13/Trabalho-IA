package br.com.lobasoftworks.trabalhoia.puzzle;

import br.com.lobasoftworks.trabalhoia.estruturas.Acao;
import br.com.lobasoftworks.trabalhoia.estruturas.Estado;

public class Esquerda extends Acao {

	public Esquerda() {
		super("Esquerda");
	}
	
	/**
	 * Executa a acao e altera o estado do ambiente.
	 * @param estado estado atual do ambiente.
	 * @return novo estado do ambiente.
	 */
	@Override
	public Estado executa(Estado estado) {
		// TODO Auto-generated method stub
		Tabuleiro atual, novo;
		int novaLinha, novaColuna;
		
		atual = (Tabuleiro) estado;
		novaLinha = atual.getLinha();
		novaColuna = atual.getColuna();
		
		if (novaColuna > 0)
			novaColuna --;
		else
			return atual;
		
		novo = new Tabuleiro(atual.getPecas(), atual.getHeuristica());
		novo.set(novaLinha, novaColuna, atual.get(atual.getLinha(), atual.getColuna()));
		novo.set(atual.getLinha(), atual.getColuna(), atual.get(novaLinha, novaColuna));
		novo.setLinha(novaLinha);
		novo.setColuna(novaColuna);
		
		return novo;
	}
}
