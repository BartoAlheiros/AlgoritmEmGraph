package grafo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Queue {

	private List<Node> nodes = new LinkedList<Node>();

	public void add(Node t) {
		this.nodes.add(t);
	}

	public Node remove() {
		return this.nodes.remove(0);
	}

	public Node findByCost(Integer ndCost) {
		
		Node nodeResult = null;
		
		for(Node nd: this.nodes) {
			if(nd.getCost().equals(ndCost)) {
				nodeResult = nd;
			}
		}
		
		return nodeResult;
	}
	
	public void updateNode(Node n) {
		
		for(Node nd: this.nodes) {
			if(nd.v == n.v) {
				nd = n;
			}
		}
		
	}
	
	public Node removeMin() {

		Integer min = Integer.MAX_VALUE/2;
		Node nodeToRemove = null;
		Integer nodeCost = null;


		for(Node nd: this.nodes) {
			nodeCost = nd.getCost();
			if(nodeCost < min) {
				min = nodeCost;
			} 
		}
		
		System.out.println("Fila de Prioridades: ");
		System.out.println(Arrays.toString(this.nodes.toArray()));
		
		System.out.println();
		System.out.println("Mínimo: " + min);
		
		nodeToRemove = this.findByCost(min);
		
		System.out.println("Noh a remover: " + nodeToRemove);
		
		System.out.println("Índice do noh a remover: " + nodes.indexOf(nodeToRemove));

		return this.nodes.remove(nodes.indexOf(nodeToRemove));

	}

	public List<Node> getNodes() {
		return this.nodes;
	}

	public Node getNode(String r) {

		Node nodeResult = new Node();
		
		for(Node nd: this.nodes) {
			if(nd.getR().equals(r)) {
				nodeResult = nd;
			}
		}

		return nodeResult;
	}
	
	public Node getByValue(Integer v) {
		
		Node nodeResult = null;
		
		for(Node n: this.nodes) {
			if(n.v == v) {
				nodeResult = n;
			}
		}
		
		return nodeResult;
		
	}

	public boolean isEmpty() {
		return this.nodes.size() == 0;
	}
	
	public String toString() {
		return Arrays.toString(this.nodes.toArray());
	}
}
