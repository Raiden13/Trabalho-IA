package br.com.lobasoftworks.trabalhoia.aspirador;

import java.util.List;

import br.com.lobasoftworks.trabalhoia.estruturas.No;

public class Largura extends EstrategiaDeBusca {

	@Override
	public void adiciona(List<No> destino, List<No> origem) {
		// TODO Auto-generated method stub
		for (No no : origem)
			destino.add(no);
	}

}
