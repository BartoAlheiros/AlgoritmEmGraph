package grafo;

public class GraphMat extends Graph {
	String[][] mat;
	private int n;
	
	// n � o n�mero de n�s
	public GraphMat(int n) {
		this.n = n;
		this.mat = new String[n][n];
	}
	
	// retorna o n�mero de n�s do grafo
	public int getN () {
		return this.n;
	}
}
