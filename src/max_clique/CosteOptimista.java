package max_clique;

public class CosteOptimista extends Estimacion{
	public int costeEstimado(Node next, int kMax) {
		// Ing�nua: todos los v�rtices restantes forman un clique
		return (next.getK() + (next.getG().getSize() - (next.getIndice() + 1)));
	}
}
