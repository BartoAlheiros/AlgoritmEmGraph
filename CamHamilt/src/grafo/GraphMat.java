package grafo;

public class GraphMat extends Graph {
	String[][] mat;
	
	public GraphMat(int nodeNumber) {
		super();
		this.mat = new String[nodeNumber][nodeNumber];
	}
}
