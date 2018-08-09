package grafo;

public class GraphMat extends Graph {
	String[][] mat;
	private int n;
	
	// n é o número de nós
	public GraphMat(int n) {
		this.n = n;
		this.mat = new String[n][n];
	}
	
	// retorna o número de nós do grafo
	public int getN () {
		return this.n;
	}
}
