package curso_programacao;

public class Main {

	public static void main(String[] args) {
		int[] vetor = new int[10];
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) Math.floor(Math.random() * vetor.length);
		}
		
		System.out.println("Desordenado: ");
		for(int j = 0; j < vetor.length; j++) {
			System.out.print(vetor[j] + " ");
		}
	}
	
}
