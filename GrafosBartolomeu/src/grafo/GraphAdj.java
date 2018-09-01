package grafo;

import java.util.ArrayList;

public class GraphAdj {
	
	private ArrayList<Node> nodes;

	/* Construtor para inicializar o grafo. A diferenca é que escolhemos utilizar 
	 * ArrayList em vez de Array. Não sendo, dessa forma, necessário passar como
	 * argumento o número N de Nós.*/
	public GraphAdj() {
		this.nodes = new ArrayList<>();
	}

	public GraphAdj(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public ArrayList<Node> getNodes() {
		return this.nodes;
	}
	
	// dado um inteiro v, retorna o Nó correspondente a este valor.
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