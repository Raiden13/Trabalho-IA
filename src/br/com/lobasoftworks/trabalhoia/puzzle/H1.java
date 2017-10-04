package br.com.lobasoftworks.trabalhoia.puzzle;

public class H1 implements Heuristica {

	@Override
	public double heuristica(int[][] pecas) {
		// TODO Auto-generated method stub
		int[][] tabela = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
		int i, j, c;
		
		c = 0;
		
		for (i = 0; i < 3; i ++)
			for (j = 0; j < 3; j ++)
				if (pecas[i][j] != tabela[i][j])
					c++;
		
		return c;
	}
}
