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
}
