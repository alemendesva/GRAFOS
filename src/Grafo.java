import java.util.Scanner;

public class Grafo {
	// Propriedades da Classe
	private boolean[][] matrizAdjacencia = null;

	// Métodos construtores da classe
	public Grafo(int qtdVertices) {
		matrizAdjacencia = new boolean[qtdVertices][qtdVertices];
	}

	// Métodos construtores da Classe
	public void construir(boolean aleatorio) {
		Scanner leitor = new Scanner(System.in);
		boolean adjacencia = false;

		for (int i = 0; i < (matrizAdjacencia.length - 1); i++) {
			for (int j = (i + 1); j < matrizAdjacencia.length; j++) {
				if (aleatorio) {
					adjacencia = (((int) (2 * Math.random())) == 0);
				} else {
					System.out.print("Digite <1> se " + i + " for amigo de " + j + ": ");
					adjacencia = (leitor.nextInt() == 1);
				}
				matrizAdjacencia[i][j] = adjacencia;
				matrizAdjacencia[j][i] = adjacencia;

			}

		}
		leitor.close();
	}
	public void imprimir() {
		for (int i = 0 ; i < matrizAdjacencia.length ; i++) {
			System.out.print(i + ": ");
			for (int j = 0 ; j < matrizAdjacencia.length ; j++) {
				if (matrizAdjacencia[i][j]) {
					System.out.print(j + ", ");
					
				}
			}
			System.out.println();
		}
	}
	public void descobrirMaiorGrau() {
		int contador = 0;
		int maior = 0;
		int maiorGrau = 0;
		
		for (int i = 0; i < matrizAdjacencia.length ; i++) {
			contador = 0;
			for (int j = 0 ; j < matrizAdjacencia.length ; j++) {
				if (matrizAdjacencia[i][j]) {
					contador++;
					
				}
			}
			if (contador > maior) {
				maior = contador;
				maiorGrau=i;
			}
		}
		System.out.println("O Vertice de maior Grau é: " + maiorGrau);
	}
}
