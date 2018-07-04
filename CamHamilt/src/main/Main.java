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
		//System.out.println(g.getNodes().get(2));
		/*for (Node n: g.getNodes().get(1).getAdj()) {
			System.out.print(n);
		}*/
		return g;
	}
	
	/*Recebe um grafo G e retorna um caminho Hamiltoniano para ele.*/
	public static ArrayList<Node> achaCamHamilt(GraphAdj g) {
		ArrayList<Node> nodesG = g.getNodes(), result = null;
		
		if (nodesG.size() == 2) {
			result = nodesG;
		} else {
			// G - v:
			GraphAdj minusG = new GraphAdj( (ArrayList<Node>)nodesG.subList( 0, nodesG.size() - 1) );
			achaCamHamilt(minusG);
			
		}
		return result;
	}
}
