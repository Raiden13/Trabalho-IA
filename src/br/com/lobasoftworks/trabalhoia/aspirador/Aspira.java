package br.com.lobasoftworks.trabalhoia.aspirador;

import br.com.lobasoftworks.trabalhoia.estruturas.Acao;
import br.com.lobasoftworks.trabalhoia.estruturas.Estado;

public class Aspira extends Acao {

	public Aspira() {
		super("Aspira");
	}
	
	/**
	 * Executa a acao e altera o estado do ambiente.
	 * @param estado estado atual do ambiente.
	 * @return novo estado do ambiente.
	 */
	@Override
	public Estado executa(Estado estado) {
		// TODO Auto-generated method stub
		Aspirador atual;
		
		atual = (Aspirador) estado;
		
		if (atual.getPosicao() == 0)
			return new Aspirador(new Situacao[] {Situacao.LIMPO, atual.getComodo(1)},
					0);
		else
			return new Aspirador(new Situacao[] { atual.getComodo(0), Situacao.LIMPO},
					1);
	}
}
