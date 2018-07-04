package grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	private String r; // rótulo do Nó
	public int v; // valor do Nó
	private ArrayList<Integer> adj; // lista de adjacências do Nó

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

	public ArrayList<Integer> getAdj() {
		return this.adj;
	}

	public String toString() {
		return this.r + " " + Integer.toString(this.v) + " - " + Arrays.toString(this.adj.toArray());
	}
	
	public void setAdj(ArrayList<Integer> adj) {
		this.adj = adj;
	}

	public boolean equals(String r, int v) {
		if ( this.r.equals(r) ) 
			return true;
		else
			return false;
	} 
}
