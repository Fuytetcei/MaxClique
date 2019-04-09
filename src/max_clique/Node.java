package max_clique;

import graph_model.GraphMatrix;

class Node {
	private GraphMatrix g;
	private int i;
	private int indice;

	public Node (GraphMatrix g, int i) {
		this.setG(g);
		this.setI(i);
	}

	public GraphMatrix getG() {
		return g;
	}
	public void setG(GraphMatrix g) {
		this.g = g;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
