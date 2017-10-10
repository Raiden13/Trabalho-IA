package br.com.lobasoftworks.trabalhoia.aspirador;

import br.com.lobasoftworks.trabalhoia.estruturas.Estado;

public class Aspirador implements Estado {
	public Situacao[] comodos;
	public int posicao;
	
	public Aspirador() {
		comodos = new Situacao[] {Situacao.SUJO, Situacao.SUJO};
	}
	
	public Aspirador(Situacao[] comodos, int posicao) {
		this.comodos = comodos;
		this.posicao = posicao;
	}
	
	public Situacao getComodo(int i) {
		return comodos[i];
	}
	
	public void setComodo(int i, Situacao s) {
		comodos[i] = s;
	}
	
	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	private int id(Situacao comodo) {
		if (comodo == Situacao.LIMPO)
			return 1;
		else
			return 0;
	}
	
	/**
	 * @return retorna um identificador unico que identifica
	 * o estado no espaco de estados do problema.
	 */
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return posicao + 2 * id(comodos[0]) + 4 * id(comodos[1]);
	}

	/**
	 * Calcula a distancia entre dois estados no espaco de estados
	 * @param estado estado anterior ao estado atual
	 * @return a distancia entre eles
	 */
	@Override
	public double distancia(Estado estado) {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * @return a distancia estimada do estado atual ate o estado
	 * objetivo.
	 */
	@Override
	public double heuristica() {
		// TODO Auto-generated method stub
		int c, i;
		
		c = 0;
		
		for (i = 0; i < 2; i ++)
			if (comodos[i] == Situacao.SUJO)
				c++;
		
		return c;
	}

	/**
	 * Realiza um teste para verificar se o estado atual eh o estado
	 * objetivo.
	 * @return "true", caso seja o estado objetivo. "false", caso 
	 * contrario.
	 */
	@Override
	public boolean eObjetivo() {
		// TODO Auto-generated method stub
		return comodos[1] == Situacao.LIMPO && comodos[0] == Situacao.LIMPO;
	}
}
