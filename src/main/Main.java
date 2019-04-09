package main;

import graph_model.GraphMatrix;
import is_clique.IsClique;

public class Main {

	public static void main(String[] args) {
		GraphMatrix g = new GraphMatrix();
		GraphMatrix gC = new GraphMatrix();
		int n = 6;
		boolean m [][] = {
				{true, true, false, false, true, false},
				{true, true, true, false, true, false},
				{false, true, true, true, false, false},
				{false, false, true, true, true, true},
				{true, true, false, true, true, false},
				{false, false, false, true, false, true}
		};

		int nC = 3;
		boolean mC [][] = {
				{true, true, true},
				{true, true, true},
				{true, true, true},
		};

		

		g.setGraph(m, n);
		gC.setGraph(mC, nC);

		System.out.println("g");
		if(IsClique.isClique(g)) {
			System.out.println("Es cliqué");
		} else {
			System.out.println("No es cliqué");
		}

		System.out.println("\ngC");
		if(IsClique.isClique(gC)) {
			System.out.println("Es cliqué");
		} else {
			System.out.println("No es cliqué");
		}
	}

}
