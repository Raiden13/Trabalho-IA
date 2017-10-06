package br.com.lobasoftworks.trabalhoia.estrategiasdebusca;

import java.util.Comparator;
import java.util.List;

import br.com.lobasoftworks.trabalhoia.estruturas.No;

public class BuscaGulosa extends EstrategiaDeBusca {

	@Override
	public void adiciona(List<No> destino, List<No> origem) {
		// TODO Auto-generated method stub
		for (No no : origem)
			destino.add(no);
		
		destino.sort(new Comparator<No>() {

			@Override
			public int compare(No arg0, No arg1) {
				// TODO Auto-generated method stub
				return Double.compare(arg0.getEstado().heuristica(),
						arg1.getEstado().heuristica());
			}
		});
	}
}
