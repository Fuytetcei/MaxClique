package max_clique;

import java.util.Date;
import java.util.PriorityQueue;

import graph_model.GraphMatrix;
import is_clique.IsClique;

public class MaxClique {

	public static Node getMaxClique(GraphMatrix g, boolean flagEstimacion) {
		int nodosExplorados = 0;
		Node res = null;
		PriorityQueue<Node> s = new PriorityQueue<Node>(1024, new NodeComparator());
		int kMejor = 0;
		boolean [] vertices = new boolean [g.getSize()];
		for(int i = 0; i < g.getSize();i++) {
			vertices[i] = false;
		}
		Node root = new Node(g, vertices,  -1, kMejor);

		// Selecciono el coste estimado
		Estimacion estimacion;
		if(flagEstimacion) {
			estimacion = new CosteOptimista();
		} else {
			estimacion = new CostePesimista();
		}
		// Preproceso el grafo
		int kMax = preprocesaGrafo(g);
		System.out.println("Como mucho hay un clique de " + kMax + " vertices");

		s.add(root);
		res = root;

		// Cuento el tiempo
		Date inicioT = new Date();

		Node curr = null;
		Node next = null;
		boolean [] v = null;
		int indice;
		while(!s.isEmpty() && (estimacion.costeEstimado(s.peek(), kMejor) > kMejor)) {
			nodosExplorados++;
			curr = s.poll();

			// Miro si soy hoja
			if((curr.getIndice() + 1) < curr.getG().getSize()) {
				// Cojo el vértice i
				indice = curr.getIndice()+1;
				v = curr.getVertices().clone();
				v[indice] = true;
				next = new Node(g, v, indice, curr.getK() + 1);

				// Miro si lleguó al tamaño máximo de clique para comprobar si es solución y terminar
				if(next.getK() == kMax) {
					next.setIndice(g.getSize()-1);
				}
				if(esSolucion(next)) {
					if(costeReal(next) > kMejor) {
						res = next;
						kMejor = res.getK();
					}
				} else {
					if(esCompletable(next, kMejor) && estimacion.costeEstimado(next, kMejor) > kMejor) {
						s.add(next);
					}
				}
				// No cojo el vértice i
				indice = curr.getIndice() + 1;
				v = curr.getVertices().clone();
				next = new Node(g, v, indice, curr.getK());
				if(esSolucion(next)) {
					if(costeReal(next) > kMejor) {
						res = next;
						kMejor = res.getK();
					}
				} else {
					if(esCompletable(next, kMejor) && estimacion.costeEstimado(next, kMejor) > kMejor) {
						s.add(next);
					}
				}
			}
		}

		// Cuento el tiempo total
		Date finalT = new Date();
		Date tiempoTotal = new Date(finalT.getTime() - inicioT.getTime());
		long tiempoMedio = tiempoTotal.getTime() / nodosExplorados;

		System.out.println();
		System.out.println("TOTAL NODOS EXPLORADOS: " + nodosExplorados);
		System.out.println("TIEMPO TOTAL: " + tiempoTotal.getTime() + " ms");
		System.out.println("TIEMPO MEDIO POR NODO: " + tiempoMedio + " ms");

		return res;
	}

	// COSTE REAL
	private static int costeReal(Node next) {
		// System.out.println("\tCoste real: " + next.getK());
		return next.getK();
	}

	// ES SOLUCION
	private static boolean esSolucion(Node next) {
		// System.out.println("\tEs solucion: " + IsClique.isClique(next.getG(), next.getVertices()) + " - " + (next.getIndice() + 1 == next.getG().getSize()));
		return IsClique.isClique(next.getG(), next.getVertices()) && (next.getIndice() + 1 == next.getG().getSize());
	}

	// ES COMPLETABLE
	private static boolean esCompletable(Node next, int kMax) {
		// System.out.println("\tEs completable: " + ((next.getK() + (next.getG().getSize() - (next.getIndice() + 1))) >= kMax));
		return ((next.getK() + (next.getG().getSize() - (next.getIndice() + 1))) >= kMax) && IsClique.isClique(next.getG(), next.getVertices());
	}

	// PREPROCESADO, coste O(n)
	private static int preprocesaGrafo(GraphMatrix g) {
		int aristas = 0;

		// Cuento el número de aristas del grafo
		for(int i=0; i<g.getSize();i++) {
			for(int j=0; j<i;j++) {
				if(g.getLink(i, j)) {
					aristas++;
				}
			}
		}

		System.out.println("Hay " + aristas + " aristas");

		// Calculo el máximo tamaño posible para un clique en este grafo
		boolean fin = true;
		int res = 1;
		int curr, next;
		next = numeroAristas(res);
		if(aristas > 0) {
			while(fin) {
				curr = next;
				next = numeroAristas(res + 1);

				if((curr < aristas) && (aristas <= next)) {
					fin = false;
				} else {
					res ++;
				}
			}
		}

		return res;
	}

	// Número de aristas para un grafo completo de n vértices
	private static int numeroAristas(int n) {
		return (n * (n-1)) / 2;
	}
}
