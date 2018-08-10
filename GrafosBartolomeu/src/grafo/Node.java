package grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	public String r; // rótulo do Nó
	public int v; // valor do Nó
	public int ante; // antecessor
	private ArrayList<Node> adj; // lista de adjacências do Nó
	public int weight;

	public Node() {
		this.adj = new ArrayList<>();
	}

	public Node(int v, String r) {
		this.v = v;
		this.r = r;
		this.adj = new ArrayList<>();
	}

	public void setR(String r) {
		this.r = r;
	}
	
	public void setV(int v) {
		this.v = v;
	}

	public ArrayList<Node> getAdj() {
		return this.adj;
	}

	public String toString() {
		return Integer.toString(this.v);
	}
	
	public void setAdj(ArrayList<Node> adj) {
		this.adj = adj;
	}

	public boolean equals(String r) {
		if ( this.r.equals(r) ) 
			return true;
		else
			return false;
	} 
}
