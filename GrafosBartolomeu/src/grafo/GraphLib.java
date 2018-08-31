package grafo;

import java.util.ArrayList;

public class GraphLib {
	
	Integer[] cost; // array de custos
	GraphAdj G;
	
	public GraphLib(Integer n, GraphAdj G) {
		cost = new Integer[n];
		this.G = G;
	}
	
	public void initialize(GraphAdj G, String r) {
		
		ArrayList<Node> nodes = G.getNodes();
		
		for (Node n: nodes) {
			cost[n.value] = Integer.MAX_VALUE/2;
			n.ante = -1;
		}
		
		cost[G.getNode(r)] = 0;
	}
	
	public void relax(int x, int y, int p) {
		
		if((cost[x] + p) < cost[y]) {
			cost[y] = cost[x] + p;
			
		}
	}
	
	public boolean bellmanFord(GraphAdj G, String r) {
		
		ArrayList<Node> nodes = G.getNodes();
		
		this.initialize(G, r);
		
		for (int i = 1; i < G.getNodes().size() - 1; i++) {
			for (Node x: nodes) {
				for (Node y: x.getAdj()) {
					this.relax(G.getNode(x.label), y.value, y.weight); 
				}
			}
		}
		
		return false;
	}
}
