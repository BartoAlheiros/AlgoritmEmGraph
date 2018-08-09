package grafo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
}
