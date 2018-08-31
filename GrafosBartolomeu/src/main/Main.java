
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
			System.out.println(n.getLabel()+" "+"- "+n+" "+Arrays.toString(n.getAdjacencyList().toArray()));
		}
	}

	static GraphAdj carregaArquivo() {
		GraphAdj g = new GraphAdj();
		FileReader arq;

		try {
			Node nd = null;
			arq = new FileReader("./data/grafo1.grf");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "", r = ""; // r � o r�tulo do n�.

			// l� a primeira linha do arquivo e armazena na variavel inteira nodesNumber
			int nodesNumber = Integer.parseInt(lerArq.readLine());   

			/* La�o que percorre todas as linhas do arquivo e salva cada n�, juntamente com sua 
			 * lista de adjac�ncias. */
			for (int i = 0; i < nodesNumber; i++) {
				int j = 0;


				linha = lerArq.readLine(); // le uma linha do arquivo - a partir da segunda - e salva na String linha 
				String[] strB = linha.split(" "); // separa linha entre espa�os e salva no array de Strings strB
				ArrayList<Node> adjacList = new ArrayList<>(); // adj � a lista de adjac�ncias do n�.
				
				if (i==0) {
					while (j < strB.length) {
						if (j == 0) {

							// adiciona primeiro noh no grafo.
							nd = new Node();
							r = strB[0]; 			// salva o r�tulo
							nd.setValue(i);	 			// salva valor do n�	'0'.
							nd.setLabel(r); 			// atribui r�tulo ao n�
							g.setNode(nd); 		// salva o primeiro n� no grafo

							// se i ainda � igual a 0(linha do arquivo referente ao primeiro noh), mas o j � maior que 0, quer dizer que estamos na lista de adjac�ncias
							// do primeiro n�. Ent�o vamos cri�-la(j� foi instanciada 'adj') e adicion�-la ao noh criado acima(o primeiro).	
							// como ainda n�o estamos considerando grafos com la�os, todo valor lido � um novo noh que ser� adicionado � lista
						}else {
							nd = g.getNode(strB[0]);
							Node nd2 = new Node();
							nd2.setValue(Integer.parseInt(strB[j]));
							g.setNode(nd2);
							nd.getAdjacencyList().add(nd2);
						}

					}
				}else {
					if(j == 0) {

						r = strB[0];

						Node result = g.getNode(i);
						if (result != null) {
							result.setLabel(r);
							Integer index = g.getNodes().indexOf(result);
							g.getNodes().set(index, result);
						}
					}else {
						Integer value;
						value = Integer.parseInt(strB[j]);
						
						Node instance= g.getNode(value);
						
						if(instance == null) {
							
							Node nd2 = new Node();
							nd2.setValue(value);
							g.getNodes().add(nd2);
							
							adjacList.add(nd2);
						} else {
							
							Node nd2 = new Node();
							Integer index = nd2.value;
							nd2 = g.getNode(index);
							
							adjacList.add(nd2);
						}
					}

				}

				/* L� a primeira linha do arquivo. */
				while (j < strB.length) {
					/* ---- S� roda uma vez. ---- 
					 * 
					 * Se se tratar do primeiro N�(i=0) e estiver no primeiro item do Array 'strB'(j=0), faz: 
					 * */
					if (i == 0) {
						
					// i > 0
					} else {

											}
					j++;	
				}

			}

			lerArq.close();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo: %s.\n", e.getMessage());
		}

		return g;
	}


}
