package br.com.lobasoftworks.trabalhoia.puzzle;

import br.com.lobasoftworks.trabalhoia.estruturas.Estado;

public class Tabuleiro implements Estado {
	private int[][] pecas;
	private int linha;
	private int coluna;
	private Heuristica heuristica;
	
	public Tabuleiro() {
		super();
		// TODO Auto-generated constructor stub
		int i, j;
		
		pecas = new int[3][3];
		
		for (i = 0; i < 3; i ++)
			for (j = 0; j < 3; j ++)
				pecas[i][j] = 3 * i + j;
		
		linha = 0;
		coluna = 0;
		
		// Heuristica padrao, caso nenhuma seja definida
		heuristica = new Heuristica() {
			
			@Override
			public double heuristica(int[][] pecas) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}

	public Tabuleiro(int[][] pecas, Heuristica heuristica) {
		super();
		int i, j;
		
		this.pecas = new int[3][3];
		  
		for (i = 0; i < 3; i ++)
			for (j = 0; j < 3; j ++) {
				this.pecas[i][j] = pecas[i][j];
				
				if (pecas[i][j] == 0) {
					linha = i;
					coluna = j;
				}
			}
		
		this.heuristica = heuristica;
	}

	public int get(int i, int j) {
		return pecas[i][j];
	}

	public void set(int i, int j, int peca) {
		pecas[i][j] = peca;
	}
	
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Heuristica getHeuristica() {
		return heuristica;
	}

	public void setHeuristica(Heuristica heuristica) {
		this.heuristica = heuristica;
	}

	public int[][] getPecas() {
		return pecas;
	}

	/**
	 * @return retorna um identificador unico que identifica
	 * o estado no espaco de estados do problema.
	 */
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		int i, j, id;
		
		id = 0;
		
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
				id = id * 10 + pecas[i][j];
		
		return id;
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
		return heuristica.heuristica(pecas);
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
		return getId() - 12345678 == 0;
	}
}
