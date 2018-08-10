
package main;

import grafo.GraphAdj;
import grafo.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		GraphAdj g = carregaArquivo();

		for (Node n: g.getNodes()) {
			System.out.println(n.r+" "+"- "+n+" "+Arrays.toString(n.getAdj().toArray()));
		}
		/*Arestas do V�rtice 1*/  
		/*ArrayList<Aresta> arestasV1 = new ArrayList<Aresta>();
    arestasV1.add(new Aresta("2"));
    arestasV1.add(new Aresta(5));*/

		/*Arestas do V�rtice 2*/  
		/*ArrayList<Aresta> arestasV2 = new ArrayList<Aresta>();
    arestasV2.add(new Aresta(1));
    arestasV2.add(new Aresta(5));
    arestasV2.add(new Aresta(3));*/

		/*Arestas do V�rtice 3*/  
		/*ArrayList<Aresta> arestasV3 = new ArrayList<Aresta>();
    arestasV3.add(new Aresta(2));
    arestasV3.add(new Aresta(4));*/

		/*Arestas do V�rtice 4*/  
		/*ArrayList<Aresta> arestasV4 = new ArrayList<Aresta>();
    arestasV4.add(new Aresta(5));
    arestasV4.add(new Aresta(3));
    arestasV4.add(new Aresta(6));*/

		/*Arestas do V�rtice 5*/  
		/*ArrayList<Aresta> arestasV5 = new ArrayList<Aresta>();
    arestasV5.add(new Aresta(1));
    arestasV5.add(new Aresta(4));
    arestasV5.add(new Aresta(2));*/

		/*Arestas do V�rtice 6*/  
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
			Node nd = null;
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
				ArrayList<Node> adj = new ArrayList<>(); // adj � a lista de adjac�ncias do n�.

				/* L� uma linha do arquivo. */
				while (j < strB.length) {
					/* Se estiver se tratar do primeiro N� e estiver no primeiro item do Array strB faz: */
					if (i == 0 && j == 0) {
						nd = new Node();
						r = strB[0]; // salva o r�tulo
						nd.setV(i);
						nd.setR(r); // atribui r�tulo ao n�
						g.setNode(nd); // inclui o n� no grafo

					} else if (i > 0 && j == 0) {
						/* Se n�o se tratar do primeiro N� e estiver no primeiro item do Array strB procura em todos os 
						 * n�s do grafo se algum tem o mesmo valor de i - j� foi adicionado - mas est� com o r�tulo nulo, atualiza o r�tulo com 
						 * a palavra de strB[0] */
						for (Node nd2: g.getNodes()) {
							if( nd2.v == i && nd2.r == null) {
								nd2.setR(strB[0]);
							}
						}

					}
				
					j++;	

				}
			}

			adj.add(nd);
		}
	
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




}
