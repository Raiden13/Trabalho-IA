package br.com.lobasoftworks.trabalhoia.aspirador;

import java.util.ArrayList;
import java.util.List;

import br.com.lobasoftworks.trabalhoia.estruturas.Estrategia;
import br.com.lobasoftworks.trabalhoia.estruturas.No;

public abstract class EstrategiaDeBusca implements Estrategia {

	@Override
	public List<No> criaLista() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
}