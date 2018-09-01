package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import grafo.GraphAdj;
import grafo.Node;

public class Main {
	
	public static GraphAdj g = null;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Integer x, y, z;
		ArrayList<Integer> adjacencyList = null;
		
		g = carregaArquivo();

		for (Node n: g.getNodes()) {
			System.out.println(n);
		}
		
		System.out.println("R�tulo de 0: " + g.getNode(0).getR());
		System.out.println("R�tulo de 2: " + g.getNode(2).getR());
		
		System.out.println("Digite uma nova aresta: ");
		System.out.print("Origem: ");
		x = input.nextInt();
		
		System.out.println("Destino: ");
		y = input.nextInt();
		
		addEdge(x,y);
		
		for (Node n: g.getNodes()) {
			System.out.println(n);
		}
		
		System.out.print("Digite um n� que deseja saber seus sucessores: ");
		z = input.nextInt();

		adjacencyList = getAdjacencyList(z);
		System.out.println(Arrays.toString(adjacencyList.toArray()));
		
		input.close();
	}

	static GraphAdj carregaArquivo() {
		GraphAdj g = new GraphAdj();
		FileReader arq;

		try {
			arq = new FileReader("./data/grafo1.grf");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "", r = ""; // r � o r�tulo do n�.

			// l� a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* La�o que percorre todas as linhas do arquivo e salva(...)*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;

				linha = lerArq.readLine(); // le uma linha do arquivo e salva na String linha
				String[] strB = linha.split(" "); // separa linha entre espa�os e salva no array de Strings strB
				Node nd = new Node();
				ArrayList<Integer> adj = new ArrayList<>(); // adj � a lista de adjac�ncias do n�.

				/* L� uma linha do arquivo. */
				while (j < strB.length) {
					if (j == 0) {
						r = strB[0]; // se a posi��o do contador for 0, insere a string lida em uma vari�vel r, que � o r�tulo do n� 
						nd.setV(i);
						nd.setR(r);
						g.setNode(nd);
					} else {
						/*Se n�o for da posi��o 0, temos arestas para a lista de adjacencias. Assim,
						 * simplismente elas s�o adicionadas a lista de adjacencias do n�.*/

						adj.add(Integer.parseInt(strB[j]));
					}
					j++;	
				}
				// Seta a lista de adjac�ncias do n�
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
		
	}
}