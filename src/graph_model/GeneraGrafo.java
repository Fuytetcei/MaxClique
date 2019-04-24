package graph_model;

import java.util.Random;

public class GeneraGrafo {
	public static GraphMatrix generaGrafoAleatorio(int n) {
		GraphMatrix res = new GraphMatrix();

		// Inicializo la matriz
		boolean [][] m = new boolean [n][n];
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				m[i][j] = false;
				if(i == j) {
					m[i][j] = true;
				}
			}
		}

		// Genero las aristas, n (n-1)/2
		Random rnd = new Random();
		int a = rnd.nextInt(((n*(n-1)) / 2 ) + 1);

		int k, l;
		while(a > 0) {
			k = rnd.nextInt((n));
			l = rnd.nextInt((n));

			if((l != k) && (!m[l][k])) {
				m[l][k] = true;
				a--;
			}
		}

		res.setGraph(m, n);

		return res;
	}

	public static GraphMatrix generaGrafoAleatorioClique(int n, int c) {
		GraphMatrix res = new GraphMatrix();

		if(n < c) {
			return null;
		}

		// Inicializo la matriz
		boolean [][] m = new boolean [n][n];
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				if(i == j) {
					m[i][j] = true;
				} else {
					m[i][j] = false;
					m[j][i] = false;
				}
			}
		}
		
		// Genero las aristas, n (n-1)/2
		Random rnd = new Random();
		int a = rnd.nextInt(((n*(n-1)) / 2 ) + 1);

		int k, l;
		while(a > 0) {
			k = rnd.nextInt((n));
			l = rnd.nextInt((n));

			if((l != k) && (!m[l][k])) {
				m[l][k] = true;
				m[k][l] = true;
				a--;
			}
		}

		// Genero un clique de c vertices
		for(int i=0; i<c;i++) {
			for(int j=0; j<c;j++) {
				m[i][j] = true;
				m[j][i] = true;
			}
		}

		res.setGraph(m, n);

		return res;
	}
}
