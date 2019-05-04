package max_clique;

public class CosteOptimista extends Estimacion{
	public int costeEstimado(Node next, int kMax) {
		// Ingénua: todos los vértices restantes forman un clique
		return (next.getK() + (next.getG().getSize() - (next.getIndice() + 1)));
	}
}
