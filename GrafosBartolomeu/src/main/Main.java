
package main;

import grafo.GraphAdj;
import grafo.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		GraphAdj g = carregaArquivo();

		for (Node n: g.getNodes()) {
			System.out.println(n);
		}
		/*Arestas do Vértice 1*/  
		/*ArrayList<Aresta> arestasV1 = new ArrayList<Aresta>();
    arestasV1.add(new Aresta("2"));
    arestasV1.add(new Aresta(5));*/

		/*Arestas do Vértice 2*/  
		/*ArrayList<Aresta> arestasV2 = new ArrayList<Aresta>();
    arestasV2.add(new Aresta(1));
    arestasV2.add(new Aresta(5));
    arestasV2.add(new Aresta(3));*/

		/*Arestas do Vértice 3*/  
		/*ArrayList<Aresta> arestasV3 = new ArrayList<Aresta>();
    arestasV3.add(new Aresta(2));
    arestasV3.add(new Aresta(4));*/

		/*Arestas do Vértice 4*/  
		/*ArrayList<Aresta> arestasV4 = new ArrayList<Aresta>();
    arestasV4.add(new Aresta(5));
    arestasV4.add(new Aresta(3));
    arestasV4.add(new Aresta(6));*/

		/*Arestas do Vértice 5*/  
		/*ArrayList<Aresta> arestasV5 = new ArrayList<Aresta>();
    arestasV5.add(new Aresta(1));
    arestasV5.add(new Aresta(4));
    arestasV5.add(new Aresta(2));*/

		/*Arestas do Vértice 6*/  
		/*ArrayList<Aresta> arestasV6 = new ArrayList<Aresta>();
    arestasV6.add(new Aresta(4));*/

		/*Adicionando os Vertices do Grafo*/
		/*ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    vertices.add(new Vertice(1, arestasV1));
    vertices.add(new Vertice(2, arestasV2));
    vertices.add(new Vertice(3, arestasV3));
    vertices.add(new Vertice(4, arestasV4));
    vertices.add(new Vertice(5, arestasV5));
    vertices.add(new Vertice(6, arestasV6));*/

		/*Grafo g = new Grafo(vertices);

    for (Vertice vertice: g.vertices) {
      System.out.print(vertice.v + ": ");
      System.out.println(vertice.e);
    }*/
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

				/* Lê uma linha do arquivo. */
				while (j < strB.length) {
					if (j == 0) {
						r = strB[0]; // se a posição do contador for 0, insere a string lida em uma variável r, que é o rótulo do nó 
						nd.setV(i);
						nd.setR(r);
						g.setNode(nd);
					} else {
						/*Se não for da posição 0, temos arestas para a lista de adjacencias. Assim,
						 * simplismente elas são adicionadas a lista de adjacencias do nó.*/

						adj.add(Integer.parseInt(strB[j]));
					}
					j++;	
				}
				// Seta a lista de adjacências do nó
				nd.setAdj(adj);
			}
			lerArq.close();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo: %s.\n", e.getMessage());
		}
		//System.out.println(g.getNodes().get(2));
		/*for (Node n: g.getNodes().get(1).getAdj()) {
			System.out.print(n);
		}*/
		return g;
	}




}
