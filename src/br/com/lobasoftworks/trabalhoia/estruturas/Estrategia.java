package br.com.lobasoftworks.trabalhoia.estruturas;

import java.util.List;

public interface Estrategia {

	/**
	 * @return uma lista vazia para armazenar os nos
	 */
	public List<No> criaLista();
	
	/**
	 * copia os nos de uma lista para outra
	 * @param destino lista que vai receber os nos
	 * @param origem lista de origem dos nos
	 */
	public void adiciona(List<No> destino, List<No> origem);
}
