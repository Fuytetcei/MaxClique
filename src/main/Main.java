package main;

import graph_model.GeneraGrafo;
import graph_model.GraphMatrix;
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

		/*int n = 3;
		boolean m [][] = {
				{true, false, false},
				{false, true, false},
				{false, false, true}
		};*/

		// boolean [] q = {true, true, false};

		g.setGraph(m, n);

		// System.out.println("Es clique: " + IsClique.isClique(g, q));

		/*Node res = MaxClique.getMaxClique(g);

		System.out.print("\nMejor clique de g: " + res.getK() + " - v: {");
		for(boolean v : res.getVertices()) {
			System.out.print(v + " ");
		}
		System.out.print("}\n");*/

		g = GeneraGrafo.generaGrafoAleatorioClique(50, 20);
		Node res = MaxClique.getMaxClique(g);

		System.out.print("\nMejor clique de g: " + res.getK() + " - v: {");
		for(boolean v : res.getVertices()) {
			System.out.print(v + " ");
		}
		System.out.print("}\n");
	}

}
