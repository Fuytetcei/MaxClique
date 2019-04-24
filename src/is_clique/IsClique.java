package is_clique;

import graph_model.GraphMatrix;

public class IsClique {

	public static boolean isClique(GraphMatrix g) {
		boolean res = true;

		for(int i = 0; i<g.getSize() && res; i++) {
			for(int j = 0; j<g.getSize() && res; j++) {
				if(!g.getLink(i, j)) {
					res = false;
				}
			}
		}

		return res;
	}

	public static boolean isClique(GraphMatrix g, boolean [] v) {
		boolean res = true;

		for(int i = 0; i<g.getSize() && res; i++) {
			if(v[i]) {
				for(int j = 0; j < i && res; j++) {
					if(v[j] && !g.getLink(i, j)) {
							res = false;
					}
				}
			}
		}

		return res;
	}
}
