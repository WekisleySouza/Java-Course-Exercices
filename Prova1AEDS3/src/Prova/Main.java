package Prova;

public class Main {

	public static void main(String[] args) {
		int[] vetor = new int[20];
		int[] vetorMerge = new int[20];
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) Math.floor(Math.random() * vetor.length);
		}
		
		System.out.print("Desordenado: ");
		for(int j = 0; j < vetor.length; j++) {
			System.out.print(vetor[j] + " ");
		}
		System.out.println("");
		
		quicksort(vetor, 0, vetor.length - 1);
		
		System.out.print("Ordenado(Quick): ");
		for(int j = 0; j < vetor.length; j++) {
			System.out.print(vetor[j] + " ");
		}
		System.out.println("");
		
		insertionSort(vetor);
		
		System.out.print("Ordenado(Insertion): ");
		for(int j = 0; j < vetor.length; j++) {
			System.out.print(vetor[j] + " ");
		}
		System.out.println("");
		
		mergeSort(vetor, vetorMerge, 0, vetor.length - 1);
		
		System.out.print("Ordenado(Merge): ");
		for(int j = 0; j < vetor.length; j++) {
			System.out.print(vetor[j] + " ");
		}
		System.out.println("");
	}
	
	//Quick Sort:
	static void quicksort(int[] vetor, int esquerda, int direita) {
		if(esquerda < direita) {
			int p = particao(vetor, esquerda, direita);
			quicksort(vetor, esquerda, p);
			quicksort(vetor, p + 1, direita);
		}
	}
	
	static int particao(int[] vetor, int esquerda, int direita) {
		int meio = (int) (esquerda + direita) / 2;
		int pivot = vetor[meio];
		int i = esquerda - 1;
		int j = direita + 1;
		while(true) {
			do {
				i++;
			}while(vetor[i] < pivot);
			do {
				j--;
			}while(vetor[j] > pivot);
			if(i >= j) {
				return j;
			}
			int aux = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = aux;
		}
	}
	
	//Insertion Sort:
	static void insertionSort(int[] vetor){
		int tamanho = vetor.length;
		for(int i = 0; i < tamanho - 1; i++) {
			int numAtual = vetor[i + 1];
			int j = i;
			while(j >= 0 && vetor[j] > numAtual) {
				vetor[j + 1] = vetor[j];
				j--;
			}
			vetor[j + 1] = numAtual;
		}
	}
	
	//Merge Sort:
	static void mergeSort(int[] vetor, int[] vetorMerge, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(vetor, vetorMerge, inicio, meio);
			mergeSort(vetor, vetorMerge, meio + 1, fim);
			merge(vetor, vetorMerge, inicio, meio, fim);
		}
	}
	
	static void merge(int[] vetor, int[] vetorMerge, int inicio, int meio, int fim) {
		for(int k = inicio; k <= fim; k++) {
			vetorMerge[k] = vetor[k];
		}
		int i = inicio;
		int j = meio + 1;
		
		for(int k = inicio; k <= fim; k++) {
			if(i > meio) {
				vetor[k] = vetorMerge[j++];
			}else if (j > fim){
				vetor[k] = vetorMerge[i++];
			}else if(vetorMerge[i] < vetorMerge[j]) {
				vetor[k] = vetorMerge[i++];
			}else {
				vetor[k] = vetorMerge[j++];
			}
		}
	}
}
