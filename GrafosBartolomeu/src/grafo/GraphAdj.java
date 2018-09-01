package grafo;

import java.util.ArrayList;

public class GraphAdj {
	
	private ArrayList<Node> nodes;

	/* Construtor para inicializar o grafo. A diferenca � que escolhemos utilizar 
	 * ArrayList em vez de Array. N�o sendo, dessa forma, necess�rio passar como
	 * argumento o n�mero N de N�s.*/
	public GraphAdj() {
		this.nodes = new ArrayList<>();
	}

	public GraphAdj(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public ArrayList<Node> getNodes() {
		return this.nodes;
	}
	
	// dado um inteiro v, retorna o N� correspondente a este valor.
	public Node getNode(Integer v) {
		
		Node result = null;
		
		for(Node n: this.nodes) {
			if(n.v == v) {
				result = n;
			}
		}
		
		return result;
	}
	
	public void setNode(Node n) {
		this.nodes.add(n);
	}
}