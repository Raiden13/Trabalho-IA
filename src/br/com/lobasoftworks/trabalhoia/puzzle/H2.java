package br.com.lobasoftworks.trabalhoia.puzzle;

public class H2 implements Heuristica {

	@Override
	public double heuristica(int[][] pecas) {
		// TODO Auto-generated method stub
		int[][] tabela = {
				{0, 0}, // 0
				{0, 1}, // 1
				{0, 2}, // 2
				{1, 0}, // 3
				{1, 1}, // 4
				{1, 1}, // 5
				{2, 0}, // 6
				{2, 1}, // 7
				{2, 2}  // 8
		};
		int i, j, c;
		
		c = 0;
		
		for (i = 0; i < 3; i ++)
			for (j = 0; i < 3; j ++) {
				c += Math.abs(i - tabela[pecas[i][j]][0]);
				c += Math.abs(j - tabela[pecas[i][j]][1]);
			}
		
		return c;
	}

}
