package br.com.lobasoftworks.trabalhoia.puzzle;

public interface Heuristica {

	/**
	 * Calcula a distancia estimada do estado atual ate
	 * o estado objetivo
	 * @param pecas disposicao das pecas no tabuleiro
	 * @return a heuristica do estado atual
	 */
	public double heuristica(int[][] pecas);
}
