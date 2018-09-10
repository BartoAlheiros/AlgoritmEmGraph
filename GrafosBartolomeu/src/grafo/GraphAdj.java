package grafo;

import java.util.ArrayList;

public class GraphAdj {
	
	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;

	/* Construtor para inicializar o grafo. A diferenca é que escolhemos utilizar 
	 * ArrayList em vez de Array. Não sendo, dessa forma, necessário passar como
	 * argumento o número N de Nós.*/
	public GraphAdj() {
		this.nodes = new ArrayList<>();
		this.edges = new ArrayList<>();
	}

	public GraphAdj(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public ArrayList<Node> getNodes() {
		return this.nodes;
	}
	
	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
	
	public Edge getEdge(Integer x, Integer y) {
		
		Edge result = null;
		Edge e2 = new Edge();
		
		e2.setX(x);
		e2.setY(y);
		
		for(Edge e: this.edges) {
			
			if(e.equals(e2)) {
				result = e;
			}
			
		}
		
		return result;
	}
	
	public void addEdge(Edge e) {
		
		this.edges.add(e);
		
	}
	
	public void removeEdge(Edge e) {
		this.edges.remove(e);
	}
	
	// dado um inteiro v, retorna o Nó correspondente a este valor.
	public Node getNode(Integer v) {
		
		Node result = null;
		
		for(Node n: this.nodes) {
			if(n.v == v) {
				result = n;
				break;
			}
		}
		
		return result;
	}
	
	public void setNode(Node n) {
		this.nodes.add(n);
	}
	
	public void removeNode(Integer v) {
		Node nd = this.getNode(v);
		this.nodes.remove(nd);
	}
}