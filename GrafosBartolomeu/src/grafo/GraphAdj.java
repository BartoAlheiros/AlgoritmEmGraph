package grafo;

import java.util.ArrayList;

public class GraphAdj extends Graph {
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
	
	public void setNode(Node n) {
		this.nodes.add(n);
	}
	
	/* Se um determinado n� est� na lista de n�s, retorna sua refer�ncia. */
	public Node getNode(String r) {
		
		Node result = null;
		
		for (Node n: this.nodes) {
			if(n.getLabel().equals(r)) {
				result = n;
			}
		}
		
		return result;
	}
	
	public Node getNode(int i) {
		Node result = null;
		
		for(Node n: this.nodes) {
			if(n.value == i) {
				result = n;
			}
		}
		
		return result;
	}
	
	public void updateNode(int i, Node n) {
		this.nodes.add(i, n);
		
	}
}
