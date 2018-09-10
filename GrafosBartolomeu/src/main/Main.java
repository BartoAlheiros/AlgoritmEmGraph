package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import grafo.Edge;
import grafo.GraphAdj;
import grafo.Node;
import grafo.Queue;
import grafo.Stack;

public class Main {

	public static GraphAdj g = null;
	public static Integer[] cost = null; // array de custos
	public static Integer time = 0; // utilizada pela dfsVisit
	public static Stack stack = new Stack(); // pilha utilizada na Ordenação Topológica.

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Selecione uma opção: ");
		System.out.println("1 - Menor caminho com Busca em Extensão");
		System.out.println("3 - Busca em Profundidade");
		System.out.println("4 - Ordem Topológica");
		System.out.println("5 - Menor caminho com Bellman-Ford");
		System.out.println("6 - Menor caminho com Dijkstra");
		System.out.println("7 - Menor caminho com Johnson");
		System.out.print("Opção: ");
		String entrada = input.next();

		switch(entrada) {
		
			case "1": runBFS();
								break;

			case "4": runTopologicalOrder();
								break;
	
			case "6": runDijkstra();
								break;
	
			case "7": runJohson();
								break;

		}

		// TODO: ajeitar isso aqui
		// ordenaTopolog();

		// printando ordem topológica
		/* for (int i = 0; i < g.getNodes().size() + 1; i++) {
			System.out.print(stack.remove().getR() + " ");
		} */

		// dfsStart();
		// printPath(0, 5);

		/* Scanner input = new Scanner(System.in);
		Integer x, y, z;
		ArrayList<Integer> adjacencyList = null;

		g = carregaArquivo();

		for (Node n: g.getNodes()) {
			System.out.println(n);
		}

		System.out.println("Arestas: ");
		for (Edge e: g.getEdges()) {
			System.out.println("(" + g.getNode(e.getX()).getR() + "," + 
					g.getNode(e.getY()).getR() + ")" + " W = " + e.getWeight());
		}

		System.out.println("Bellman-Ford: ");
		bellmanFord(1);
		System.out.print("B - E: " ); printPath(1, 4);
		System.out.println();

		dijkstra(1);
		System.out.println("B - E: "); printPath(1, 4); */
		// System.out.println();
		// System.out.print("A - E: "); printPath(0, 4);

		/*System.out.println("Rótulo de 0: " + g.getNode(0).getR());
		System.out.println("Rótulo de 2: " + g.getNode(2).getR());

		// essa busca é válida para o grafo dado como exemplo na lista da 1aVA.
		BFS(0);
		

		System.out.println("Digite uma nova aresta: ");
		System.out.print("Origem: ");
		x = input.nextInt();

		System.out.println("Destino: ");
		y = input.nextInt();

		addEdge(x,y);

		for (Node n: g.getNodes()) {
			System.out.println(n);
		}

		System.out.print("Digite um nó que deseja saber seus sucessores: ");
		z = input.nextInt();

		adjacencyList = getAdjacencyList(z);
		System.out.println(Arrays.toString(adjacencyList.toArray()));

		System.out.println("Digite um arco para saber se ele existe: ");
		System.out.print("Origem: ");
		x = input.nextInt();

		System.out.println("Destino: ");
		y = input.nextInt();

		boolean result = edgeExists(x, y);
		System.out.println(result); */

		input.close();
	}
	
	public static void runBFS() {
		
		Scanner input = new Scanner(System.in);
		Integer entrada = null;
		String fileName = "grafoBuscaExtensao.grf";
		g = carregaArquivo(fileName, false);
		
		for (Node n: g.getNodes()) {
			System.out.println(n + "Cost = " + n.getCost());
		}

		System.out.println("Arestas: ");
		for (Edge e: g.getEdges()) {
			if(g.getNode(e.getX()) != null) {
				System.out.println("(" + g.getNode(e.getX()).getR() + "," + 
						g.getNode(e.getY()).getR() + ")" + " W = " + e.getWeight());
			}

		}
		
		System.out.print("Digite um nó(o seu índice) para iniciar a busca: ");
		
		entrada = input.nextInt();
		BFS(entrada);

		for(Node nd: g.getNodes()) {
			if(nd.v != 0) {
				printPath(entrada,nd.v);
				System.out.println();
			}
		}
		
		input.close();

	}
	
	public static void runTopologicalOrder() {
		
		String fileName = "grafoOrdTopologica.grf";
		g = carregaArquivo(fileName, false);
		
		for (Node n: g.getNodes()) {
			System.out.println(n);
		}

		System.out.println("Arestas: ");
		for (Edge e: g.getEdges()) {
			System.out.println("(" + g.getNode(e.getX()).getR() + "," + 
					g.getNode(e.getY()).getR() + ")" + " W = " + e.getWeight());
		}
		
		ordenaTopolog();

		// printando ordem topológica
		for (int i = 0; i < g.getNodes().size() + 1; i++) {
			System.out.print(stack.remove().getR() + " ");
		} 

	}

	public static void runDijkstra() {

		Scanner input = new Scanner(System.in);
		Integer inicio = null, destino = null;
		String fileName = "grafoDijkstraBellmanF.grf";
		g = carregaArquivo(fileName, false);

		for (Node n: g.getNodes()) {
			System.out.println(n);
		}

		System.out.println("Arestas: ");
		for (Edge e: g.getEdges()) {
			System.out.println("(" + g.getNode(e.getX()).getR() + "," + 
					g.getNode(e.getY()).getR() + ")" + " W = " + e.getWeight());
		}

		System.out.print("Entre com o vértice de início(valor do vértice): ");
		inicio = input.nextInt();
		dijkstra(inicio);

		System.out.print("Entre com o vértice de destino: ");
		destino = input.nextInt();

		printPath(inicio, destino);
		System.out.print("Custo: " + g.getNode(destino).getCost());

	}

	public static void runJohson() {

		Integer[][] d = null;
		String fileName = "grafoJohnson.grf";
		g = carregaArquivo(fileName, true);

		d = johnson();

		for (Node n: g.getNodes()) {
			System.out.println(n + "Cost = " + n.getCost());
		}

		System.out.println("Arestas: ");
		for (Edge e: g.getEdges()) {
			if(g.getNode(e.getX()) != null) {
				System.out.println("(" + g.getNode(e.getX()).getR() + "," + 
						g.getNode(e.getY()).getR() + ")" + " W = " + e.getWeight());
			}

		}

		System.out.println("Matriz D: ");
		for (int l = 0; l < d.length; l++)  {  
			for (int c = 0; c < d[0].length; c++)     { 
				System.out.print(d[l][c] + " "); //imprime caracter a caracter
			}  
			System.out.println(" "); //muda de linha
		}

	}

	static GraphAdj carregaArquivo(String fileName, boolean johnson) {

		GraphAdj g = new GraphAdj();
		FileReader arq;

		try {
			arq = new FileReader("./data/" + fileName);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "", r = ""; // r é o rótulo do nó.

			// lê a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* Laço que percorre todas as linhas do arquivo e salva(...)*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;

				linha = lerArq.readLine(); // le uma linha do arquivo e salva na String linha
				String[] strB = linha.split(" "); // separa linha entre espaços e salva no array de Strings strB
				Node nd = new Node();
				ArrayList<Integer> adj = new ArrayList<>(); // adj é a lista de adjacências do nó.
				Integer t = null;

				/* Lê uma linha do arquivo. */
				while (j < strB.length) {
					if (j == 0) {
						r = strB[0]; // se a posição do contador for 0, insere a string lida em uma variável r, que é o rótulo do nó 
						nd.v = i;
						nd.setR(r);
						g.setNode(nd);
					} else {
						/*Se não for da posição 0, temos arestas para a lista de adjacencias. Assim,
						 * simplismente elas são adicionadas a lista de adjacencias do nó.*/
						Node nodeY = new Node();
						Edge e = new Edge();
						Integer weight = null;
						t = j++;

						nodeY.v = Integer.parseInt( strB [ j - 1 ] );
						weight = Integer.parseInt( strB [ t + 1 ] );

						e.setX(i);
						e.setY(nodeY.v);
						e.setWeight(weight);

						adj.add(nodeY.v);
						g.addEdge(e);

					}
					j++;
					// if (j == 1) t = j;
				}
				// Seta a lista de adjacências do nó
				nd.setAdj(adj);
			}

			// lê o peso dos vértices
			if(johnson) {

				Node nd = new Node();

				for (int i = 0; i < numVertices; i++) { 

					linha = lerArq.readLine(); // le uma linha do arquivo e salva na String linha
					String[] strB = linha.split(" "); // separa linha entre espaços e salva no array de Strings strB

					nd = g.getNode(Integer.parseInt(strB[0]));
					nd.setCost(Integer.parseInt(strB[1]));
				} 
			}

			lerArq.close();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo: %s.\n", e.getMessage());
		}

		return g;
	}

	// adiciona aresta
	public static void addEdge(Integer x, Integer y) {

		Node nodeX = g.getNode(x);
		Node nodeY = g.getNode(y);

		nodeX.getAdj().add(nodeY.v);
	}

	public static ArrayList<Integer> getAdjacencyList(Integer x) {

		Node node = g.getNode(x);

		return node.getAdj(); 
	}

	public static boolean edgeExists(Integer x, Integer y) {

		boolean result = false;

		Node nodeX = g.getNode(x);
		Node nodeY = g.getNode(y);

		result = nodeX.getAdj().contains(nodeY.v);

		return result;
	}

	public static void BFS(Integer s) {

		Queue queue = new Queue();
		Node nodeS = g.getNode(s);
		Node u = null;

		for(Node n: g.getNodes()) {
			n.setCor("BRANCO");
			n.setD(Integer.MAX_VALUE/2);
			n.setAnte(null);
			g.getNodes().set(g.getNodes().indexOf(n), n);
		}

		nodeS.setCor("CINZA");
		nodeS.setD(0);
		queue.add(nodeS);
		g.getNodes().set(g.getNodes().indexOf(nodeS), nodeS);

		while( !queue.isEmpty() ) {
			u = queue.remove();

			for(Integer nodeValue: u.getAdj()) {

				Node node = g.getNode(nodeValue);

				if(node.getCor().equals("BRANCO")) {

					node.setCor("CINZA");
					node.setD(u.getD() + 1);
					node.setAnte(u.v);
					queue.add(node);
					g.getNodes().set(g.getNodes().indexOf(node), node);
				}
			}

			u.setCor("PRETO");
			g.getNodes().set(g.getNodes().indexOf(u), u);
		}

	}

	public static void printPath(Integer s, Integer n) {

		Node nodeS = g.getNode(s);
		Node nodeX = g.getNode(n);

		if(nodeX.equals(nodeS)) {
			System.out.print(g.getNode(s).getR() + " ");
		} else {
			if (nodeX.getAnte() == -1) {
				System.out.println("Não há caminho.");
			} else {
				printPath(nodeS.v, nodeX.getAnte());
				System.out.print(g.getNode(nodeX.v).getR() + " ");
			}
		}
	}

	// 2a VA

	public static void initialize(Integer s) {

		ArrayList<Node> nodes = g.getNodes();
		Node nodeS = g.getNode(s);

		for (Node n: nodes) {
			n.setCost(Integer.MAX_VALUE/2);
			n.setAnte(-1);
		}

		nodeS.setCost(0);
	}

	public static void relax(int x, int y, int p) {

		Node nodeX = null, nodeY = null;
		nodeX = g.getNode(x);
		nodeY = g.getNode(y);

		if( ( nodeX.getCost() + p ) < nodeY.getCost() ) {
			nodeY.setCost(nodeX.getCost() + p);
			nodeY.setAnte(nodeX.v);
		}
	}

	public static boolean bellmanFord(Integer s, boolean init) {

		boolean result = true;
		ArrayList<Node> nodes = g.getNodes();

		if(init) {

			initialize(s);

		}

		for (int i = 1; i < nodes.size(); i++) {
			for (Node nodeX: nodes) {
				for (Integer y: nodeX.getAdj()) {

					Node nodeY = g.getNode(y);
					relax(nodeX.v, nodeY.v, g.getEdge(nodeX.v, nodeY.v).getWeight()); 
				}
			}
		}

		for(Edge edg: g.getEdges()) {

			Node nodeX = g.getNode(edg.getX());
			Node nodeY = g.getNode(edg.getY());

			if(nodeY.getCost() > nodeX.getCost() + edg.getWeight() ) {
				result = false;
			}
		}

		return result;

	}

	public static void dijkstra(Integer s) {

		Queue q = new Queue();
		Queue priorityQueue = new Queue();

		initialize(s);
		priorityQueue = build(q);

		while( !priorityQueue.isEmpty() ) {
			Node x = null;
			x = priorityQueue.removeMin();

			for(Integer y: x.getAdj()) {

				Node nodeY = g.getNode(y);
				Integer xCost = x.getCost();
				Integer p = g.getEdge(x.v, y).getWeight();
				Integer yCost = nodeY.getCost();

				if( xCost + p < yCost ) {
					nodeY.setAnte( x.v );
					nodeY.setCost( xCost + p );
					yCost = xCost + p;
					decreaseKey(priorityQueue, nodeY, yCost);
				}

			}
		}

	}

	public static void decreaseKey(Queue q, Node y, Integer yCost) {

		Node nd = q.getByValue(y.v);

		nd.setCost(yCost);

		q.updateNode(nd);		
	}

	public static Queue build(Queue q) {

		ArrayList<Node> nodes = g.getNodes();
		Queue priorityQueue = null;

		for(Node nd: nodes) {
			q.add(nd);
		}

		priorityQueue = q;

		return priorityQueue;
	}

	public static Integer[][] johnson() {

		ArrayList<Integer> costAnte = new ArrayList<Integer>();
		Integer[][] d = new Integer[g.getNodes().size()][g.getNodes().size()];
		ArrayList<Integer> qAdjList = new ArrayList<Integer>();
		Node q = new Node();

		q.setR("q");
		q.v = 5;
		q.setCost(0);
		g.setNode(q);

		for(Node nd: g.getNodes()) {
			if(nd.v != q.v) {
				Edge edg = new Edge();
				edg.setX(q.v);
				edg.setY(nd.v);
				edg.setWeight(0);
				qAdjList.add(nd.v);
				g.addEdge(edg);
			}
		}

		q.setAdj(qAdjList);

		if(bellmanFord(q.v, false) == false) {
			System.out.println("the input graph contains a negative-weight cycle");
		} else {
			// atribuir o peso a cada noh o bellmanFord já faz, através do relax

			// recalcula o peso das arestas
			for(Edge edg: g.getEdges()) {
				Integer reweight = ( edg.getWeight() + g.getNode(edg.getX()).getCost() ) - g.getNode(edg.getY()).getCost();
				edg.setWeight(reweight);
			}

			// salvando os custos dos nohs
			for(Node ndBack: g.getNodes()) {
				costAnte.add(ndBack.getCost());
			}

			// remove arestas saindo de q
			for(Node nd: g.getNodes()) {
				if(nd.v == q.v) {
					for(Integer nd2: nd.getAdj()) {
						Edge edg = g.getEdge(q.v, nd2);
						g.removeEdge(edg);
					}
				}
			}

			// remove noh extra q
			g.removeNode(q.v);

			for(Node nd: g.getNodes()) {
				dijkstra(nd.v);
				for(Node nd2: g.getNodes()) {

					Integer hv = costAnte.get(g.getNodes().indexOf(nd2));
					Integer hu = costAnte.get(g.getNodes().indexOf(nd));
					Integer costuV = nd2.getCost();

					d[g.getNodes().indexOf(nd)][g.getNodes().indexOf(nd2)] = costuV + hv - hu;   
				}
			}

		}

		return d;
	}

	public static void dfsStart() {

		for(Node nd: g.getNodes()) {
			nd.setCor("BRANCO");
			nd.setInitialTime(-1);
			nd.setFinalTime(-1);
			nd.setAnte(-1);
		}

		time = 1;

		for(Node nd: g.getNodes()) {
			if(nd.getCor().equals("BRANCO")) {
				dfsVisit(nd);
			}
		}

	}

	public static void dfsVisit(Node u) {

		u.setCor("CINZA");
		u.setInitialTime(time++);

		for(Integer v: u.getAdj()) {

			Node nodeV = null;
			nodeV = g.getNode(v);

			if(nodeV.getCor().equals("BRANCO")) {
				nodeV.setAnte(u.v);
				dfsVisit(nodeV);
			}
		}

		u.setCor("PRETO");
		u.setFinalTime(time++);
	}

	public static void ordenaTopolog() {

		for(Node nd: g.getNodes()) {
			nd.setCor("BRANCO");
			nd.setInitialTime(-1);
			nd.setFinalTime(-1);
			nd.setAnte(-1);
		}

		time = 1;

		for(Node nd: g.getNodes()) {
			if(nd.getCor().equals("BRANCO")) {
				dfsVisitOT(nd);
			}
		}
	}

	public static void dfsVisitOT(Node u) {

		u.setCor("CINZA");
		u.setInitialTime(time++);

		for(Integer v: u.getAdj()) {

			Node nodeV = null;
			nodeV = g.getNode(v);

			if(nodeV.getCor().equals("BRANCO")) {
				nodeV.setAnte(u.v);
				dfsVisitOT(nodeV);
			} 
		}

		u.setCor("PRETO");
		u.setFinalTime(time++);

		stack.insert(u);

	}

	// não usado
	public static boolean hasCycle() {

		boolean hasCycle = false;

		ArrayList<Edge> edgeList = g.getEdges();
		ArrayList<Edge> ordList = new ArrayList<Edge>();
		Queue q = new Queue();

		for(Edge edg: edgeList) {
			Node ndIn = g.getNode(edg.getX());
			q.add(ndIn);
			Node ndOut = q.remove();

			for(@SuppressWarnings("unused") 
			Edge edg2: edgeList) {

				if(edg.getX().equals(ndOut.v)) {
					Node nd = g.getNode(edg.getY());

					if(q.getNodes().indexOf(nd) == -1) {
						q.add(nd);
					} else {
						hasCycle = true;
					}	
				}
			}

			if(hasCycle == true) {
				ordList.add(edg);
				printCycle(q, ordList, edg);
				break;
			} else {
				ordList.add(edg);
			}

		}

		return hasCycle;
	}

	// não usado
	private static void printCycle(Queue q, ArrayList<Edge> ordList, Edge edg) {

		List<Node> cycle = new LinkedList<Node>();

		Node nodeY = null;
		nodeY = g.getNode(edg.getY());
		cycle.add(nodeY);	

		for(Edge edg2: ordList) {
			if(edg.getX().equals(edg2.getY())) {
				nodeY = g.getNode(edg2.getY());
				cycle.add(nodeY);
			}
		}
	}
}