package main;

import graph_model.GraphMatrix;
// import is_clique.IsClique;
import max_clique.MaxClique;
import max_clique.Node;

public class Main {

	public static void main(String[] args) {
		GraphMatrix g = new GraphMatrix();
		int n = 6;
		boolean m [][] = {
				{true, true, false, false, true, false},
				{true, true, true, false, true, false},
				{false, true, true, true, false, false},
				{false, false, true, true, true, true},
				{true, true, false, true, true, false},
				{false, false, false, true, false, true}
		};


		// boolean [] v = {true, true, false, false, true, false};
		

		g.setGraph(m, n);

	    /* System.out.println("g");
		if(IsClique.isClique(g)) {
			System.out.println("Es cliqué");
		} else {
			System.out.println("No es cliqué");
		}

		System.out.println("\ng'");
		if(IsClique.isClique(g, v)) {
			System.out.println("Es cliqué");
		} else {
			System.out.println("No es cliqué");
		} */

		Node res = MaxClique.getMaxClique(g);

		System.out.print("\nMejor clique de g: " + res.getK() + " - v: {");
		for(boolean v : res.getVertices()) {
			System.out.print(v + " ");
		}
		System.out.print("}\n");
	}

}
