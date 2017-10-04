package br.com.lobasoftworks.trabalhoia.estruturas;

public interface Estado {

	/**
	 * @return retorna um identificador unico que identifica
	 * o estado no espaco de estados do problema.
	 */
	public long getId();
	
	/**
	 * Calcula a distancia entre dois estados no espaco de estados
	 * @param estado estado anterior ao estado atual
	 * @return a distancia entre eles
	 */
	public double distancia(Estado estado);
	
	/**
	 * @return a distancia estimada do estado atual ate o estado
	 * objetivo.
	 */
	public double heuristica();
	
	/**
	 * Realiza um teste para verificar se o estado atual eh o estado
	 * objetivo.
	 * @return "true", caso seja o estado objetivo. "false", caso 
	 * contrario.
	 */
	public boolean eObjetivo();
}
