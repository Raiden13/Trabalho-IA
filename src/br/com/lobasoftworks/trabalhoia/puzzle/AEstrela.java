package br.com.lobasoftworks.trabalhoia.puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.lobasoftworks.trabalhoia.estruturas.Estrategia;
import br.com.lobasoftworks.trabalhoia.estruturas.No;

public class AEstrela implements Estrategia {

	@Override
	public List<No> criaLista() {
		// TODO Auto-generated method stub
		return new ArrayList<No>();
	}

	@Override
	public void adiciona(List<No> destino, List<No> origem) {
		// TODO Auto-generated method stub
		for (No no : origem)
			destino.add(no);
		
		destino.sort(new Comparator<No>() {

			@Override
			public int compare(No arg0, No arg1) {
				// TODO Auto-generated method stub
				return Double.compare(arg0.getDistancia(), arg1.getDistancia());
			}
		});
	}

}
