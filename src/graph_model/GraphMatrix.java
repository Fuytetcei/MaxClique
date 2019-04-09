package graph_model;

public class GraphMatrix {

	int n;
	boolean m [][];

	public GraphMatrix(int n) {
		this.n = n;
		m = new boolean[n][];
		for(int i =0;i<n;i++) {
			m[i] = new boolean[n];
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j] = false;
			}
		}
	}

	public GraphMatrix() {}

	public void setLink(int x, int y) {
		m[x][y] = true;
		m[y][x] = true;
	}

	public boolean getLink(int x, int y) {
		return m[x][y];
	}

	public int getSize() {
		return n;
	}

	public void setGraph(boolean [][] m, int n) {
		this.m = m;
		this.n = n;
	}
}
