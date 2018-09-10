package grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	
	private String r; // rótulo do Nó
	public int v; // valor do Nó
	private ArrayList<Integer> adj; // lista de adjacências do Nó
	private String cor;
	private Integer d;
	private Integer ante;
	private Integer cost;
	private Integer initialTime;
	private Integer finalTime;

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
	
	public String getR() {
		return this.r;
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getD() {
		return d;
	}

	public void setD(Integer d) {
		this.d = d;
	}
	
	public Integer getInitialTime() {
		return finalTime;
	}

	public void setInitialTime(Integer init) {
		this.initialTime = init;
	}

	public Integer getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(Integer fin) {
		this.finalTime = fin;
	}

	public Integer getAnte() {
		return ante;
	}

	public void setAnte(Integer ante) {
		this.ante = ante;
	}

	public ArrayList<Integer> getAdj() {
		return this.adj;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer w) {
		this.cost = w;
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