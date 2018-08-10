package grafo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	// returns true if a node exists on the graph and false if it doesn't with an int argument
	public boolean exists(int ) {}
	
	// retorna o valor do n�, recebendo como argumento seu r�tulo
	public int getNode(String r) {
		
		int value = 0;
		
		for (Node n: this.nodes) {
			if(n.r.equals(r)) {
				value = n.v;
			}
		}
		
		return value;
	}
}
