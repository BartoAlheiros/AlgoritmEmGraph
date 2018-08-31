package grafo;

import java.util.ArrayList;

public class Node {
	
	public int value; // valor do Nó "chave"
	private String label; // rótulo do Nó
	public Node ante; // antecessor
	private ArrayList<Node> adjacList; // lista de adjacências do Nó
	public int weight;

	public Node() {
		this.adjacList = new ArrayList<>();
	}

	public Node(int v, String r) {
		this.value = v;
		this.label = r;
		this.adjacList = new ArrayList<>();
	}
	 
	public String getLabel() {
		return this.label;
	}
	
	public void setLabel(String lbl) {
		this.label = lbl;
	}
	
	public void setValue(int v) {
		this.value = v;
	}

	public ArrayList<Node> getAdjacencyList() {
		return this.adjacList;
	}

	public String toString() {
		return Integer.toString(this.value);
	}
	
	public void setAdjacencyList(ArrayList<Node> adj) {
		this.adjacList = adj;
	}

	public boolean equals(int value, String label) {
		if ( this.value == value && label.equals(this.label)) 
			return true;
		else
			return false;
	} 
}
