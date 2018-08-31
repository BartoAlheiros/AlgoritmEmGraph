package grafo;

import java.util.ArrayList;

public class GraphAdj extends Graph {
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
	
	public void setNode(Node n) {
		this.nodes.add(n);
	}
	
	/* Se um determinado nó está na lista de nós, retorna sua referência. */
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
