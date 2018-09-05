package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import grafo.Edge;
import grafo.GraphAdj;
import grafo.Node;
import grafo.Queue;

public class Main {

	public static GraphAdj g = null;
	public static Integer[] cost = null; // array de custos

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
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
		bellmanFord(0);
		System.out.print("A - D: " ); printPath(0, 3);
		System.out.println();

		dijkstra(0);
		System.out.println("A - D: "); printPath(0, 3);
		// System.out.println();
		// System.out.print("A - E: "); printPath(0, 4);

		/*System.out.println("Rótulo de 0: " + g.getNode(0).getR());
		System.out.println("Rótulo de 2: " + g.getNode(2).getR());

		// essa busca é válida para o grafo dado como exemplo na lista da 1aVA.
		BFS(0);
		printPath(0,1);
		System.out.println();
		printPath(0,2);
		System.out.println();
		printPath(0,3);
		System.out.println();
		printPath(0,4);
		System.out.println();
		printPath(0, 5);

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

	static GraphAdj carregaArquivo() {

		GraphAdj g = new GraphAdj();
		FileReader arq;

		try {
			arq = new FileReader("./data/grafo1.grf");
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

	public static void bellmanFord(Integer s) {

		ArrayList<Node> nodes = g.getNodes();

		initialize(s);

		for (int i = 1; i < nodes.size(); i++) {
			for (Node nodeX: nodes) {
				for (Integer y: nodeX.getAdj()) {

					Node nodeY = g.getNode(y);
					relax(nodeX.v, nodeY.v, g.getEdge(nodeX.v, nodeY.v).getWeight()); 
				}
			}
		}

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
			// nd.setCost(Integer.MAX_VALUE/2);
			q.add(nd);
		}

		priorityQueue = q;

		System.out.println("Fila de prioridades do build: \n" + priorityQueue);

		return priorityQueue;
	}

}