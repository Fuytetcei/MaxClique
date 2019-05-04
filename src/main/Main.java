package main;

import graph_model.GeneraGrafo;
import graph_model.GraphMatrix;
import max_clique.MaxClique;
import max_clique.Node;

public class Main {

	public static void main(String[] args) {
		GraphMatrix g = new GraphMatrix();
		/*int n = 6;
		boolean m [][] = {
				{true, true, false, false, true, false},
				{true, true, true, false, true, false},
				{false, true, true, true, false, false},
				{false, false, true, true, true, true},
				{true, true, false, true, true, false},
				{false, false, false, true, false, true}
		};*/

		/*int n = 3;
		boolean m [][] = {
				{true, false, false},
				{false, true, false},
				{false, false, true}
		};*/

		/*int n = 10;
		boolean m [][] = {
				{true, true, true, true, true, true, true, false, false, false},
				{true, true, true, true, true, true, true, false, false, false},
				{true, true, true, true, true, true, true, false, false, false},
				{true, true, true, true, true, true, true, false, false, false},
				{true, true, true, true, true, true, true, false, false, false},
				{true, true, true, true, true, true, true, false, false, false},
				{true, true, true, true, true, true, true, false, false, false},
				{false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false, false}
		};*/

		// g.setGraph(m, n);

		g = GeneraGrafo.generaGrafoAleatorioClique(10, 5);
		// Coste optimista
		Node resOp = MaxClique.getMaxClique(g, false);
		// Coste pesimista
		//Node resPe = MaxClique.getMaxClique(g, false);

		System.out.println("Coste optimista");
		System.out.print("\nMejor clique de g: " + resOp.getK() + " - v: {");
		for(boolean v : resOp.getVertices()) {
			System.out.print(v + " ");
		}
		System.out.print("}\n");
		/*System.out.println("Coste pesimista");
		System.out.print("\nMejor clique de g: " + resPe.getK() + " - v: {");
		for(boolean v : resPe.getVertices()) {
			System.out.print(v + " ");
		}
		System.out.print("}\n");*/
	}

}
