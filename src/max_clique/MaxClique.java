package max_clique;

import java.util.Stack;

import graph_model.GraphMatrix;
import is_clique.IsClique;

public class MaxClique {

	public static Node getMaxClique(GraphMatrix g) {
		Node res = null;
		Stack<Node> s = new Stack<Node>();
		int kMax = 0;
		boolean [] vertices = new boolean [g.getSize()];
		for(int i = 0; i < g.getSize();i++) {
			vertices[i] = false;
		}
		Node root = new Node(g, vertices,  -1, kMax);

		s.add(root);
		res = root;

		System.out.println("Inicializo raíz");

		Node curr = null;
		Node next = null;
		boolean [] v = null;
		int indice;
		while(!s.isEmpty() && (costeEstimado(s.peek(), kMax) > kMax)) {
			curr = s.pop();
			System.out.println("curr - k: " + curr.getK() + " - i: " + curr.getIndice());

			if((curr.getIndice() + 1) < curr.getG().getSize()) {
				// Cojo el vértice i
				indice = curr.getIndice()+1;
				v = curr.getVertices().clone();
				v[indice] = true;
				next = new Node(g, v, indice, kMax + 1);
				if(esSolucion(next)) {
					if(costeReal(next) > kMax) {
						res = next;
					}
				} else {
					if(esCompletable(next, kMax) && costeEstimado(next, kMax) > kMax) {
						s.add(next);
					}
				}
				// No cojo el vértice i
				// Solo compruebo si es factible ya que es igual que el padre pero con un nodo disponible menos
				indice = curr.getIndice() + 1;
				v = curr.getVertices().clone();
				next = new Node(g, v, indice, kMax + 1);
				if(esCompletable(next, kMax)) {
					s.add(next);
				}
			}
		}

		return res;
	}

	private static int costeReal(Node next) {
		System.out.println("\tCoste real: " + next.getK());
		return next.getK();
	}
	private static int costeEstimado(Node next, int kMax) {
		// Ingénua: todos los vértices restantes forman un clique
		System.out.println("\tcoste estimado: " + (next.getK() + (next.getG().getSize() - (next.getIndice() + 1))));
		return (next.getK() + (next.getG().getSize() - (next.getIndice() + 1)));
		// Ajustada: Al menos hay un clique de tamaño kMax para los siguientes nodos restantes
		/*int res;
		Node estimado = null;
		int indice = next.getIndice() + (kMax - next.getK());
		boolean [] v = next.getVertices().clone();
		
		v[indice] = true;
		estimado = new Node(next.getG(), v, indice, kMax + 1);

		for(int i = next.getIndice(); i < estimado.getIndice(); i++) {
			v[i] = true;
		}

		if(IsClique.isClique(estimado.getG(), estimado.getVertices())) {
			res = estimado.getK();
		} else {
			res = -1;
		}

		return res;*/
	}
	private static boolean esSolucion(Node next) {
		System.out.println("\tEs solucion: " + IsClique.isClique(next.getG(), next.getVertices()) + " - " + (next.getIndice() + 1 == next.getG().getSize()));
		return IsClique.isClique(next.getG(), next.getVertices()) && (next.getIndice() + 1 == next.getG().getSize());
	}
	private static boolean esCompletable(Node next, int kMax) {
		System.out.println("\tEs completable: " + ((next.getK() + (next.getG().getSize() - (next.getIndice() + 1))) >= kMax));
		return (next.getK() + (next.getG().getSize() - (next.getIndice() + 1))) >= kMax;
	}
}

/*
 * TODO:
 *  - SYSTEM COPYOFARRAY!! ***********************
 * 	- Implementar costeEstimado()
 * 	- Esquema general de maximización
 *  - Implementar esSolucion()
 *  - Implementar costeReal()
 * 
 * DONE:
 * - Implementar esCompletable()
 */
