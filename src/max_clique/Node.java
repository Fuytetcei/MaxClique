package max_clique;

import graph_model.GraphMatrix;

public class Node {
	private GraphMatrix g;
	private boolean [] vertices;
	private int indice;
	private int k;

	public Node (GraphMatrix g, boolean [] v, int i, int k) {
		this.setG(g);
		this.indice = i;
		this.setVertices(v);
		this.setK(k);
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
	public boolean [] getVertices() {
		return vertices;
	}
	public void setVertices(boolean [] vertices) {
		this.vertices = vertices;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
}
