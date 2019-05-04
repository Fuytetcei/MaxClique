package max_clique;

import is_clique.IsClique;

public class CostePesimista extends Estimacion{
	public int costeEstimado(Node next, int kMax) {
		// Ajustada: Al menos hay un clique de tamaño (kMax + 1) para los nodos restantes
		int res;
		Node estimado = null;
		int indice = next.getIndice() + (kMax - next.getK()) + 1;
		boolean [] v = next.getVertices().clone();
		
		v[indice] = true;
		estimado = new Node(next.getG(), v, indice, kMax + 1);

		for(int i = next.getIndice()+1; i < estimado.getIndice(); i++) {
			v[i] = true;
		}

		if(IsClique.isClique(estimado.getG(), estimado.getVertices())) {
			System.out.println("Mejor clique: " + estimado.getK() + " indice: " + indice);
			res = estimado.getK();
		} else {
			System.out.println("No mejor: " + estimado.getK() + " indice: " + indice);
			res = -1;
		}

		return res;
	}
}
