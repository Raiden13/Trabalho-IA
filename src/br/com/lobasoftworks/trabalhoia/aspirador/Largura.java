package br.com.lobasoftworks.trabalhoia.aspirador;

import java.util.List;

import br.com.lobasoftworks.trabalhoia.estruturas.No;

public class Largura extends EstrategiaDeBusca {

	/**
	 * copia os nos de uma lista para outra
	 * @param destino lista que vai receber os nos
	 * @param origem lista de origem dos nos
	 */
	@Override
	public void adiciona(List<No> destino, List<No> origem) {
		// TODO Auto-generated method stub
		for (No no : origem)
			destino.add(no);
	}

}
