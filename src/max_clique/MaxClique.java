package max_clique;

import java.util.Stack;

import graph_model.GraphMatrix;

public class MaxClique {

	public static GraphMatrix getMaxClique(GraphMatrix g) {
		GraphMatrix res = null;
		Stack<Node> s = new Stack<Node>();
		Node root = new Node(g, 0);

		s.add(root);

		while(!s.isEmpty()) {
			
		}

		return res;
	}
}
