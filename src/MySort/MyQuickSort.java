package MySort;

public class MyQuickSort {
	int[] array;

	public MyQuickSort(int[] array) {
		this.array = array;
	}

	private void swap(int i, int j) {
		if (i == j)
			return;
		int temp = array[i]; // Guarda o valor do array na posição i
		array[i] = array[j]; // Faz o swap
		array[j] = temp; // Recupera o valor guardado e atribui a posição j
	}

	private int partition(int low, int high) {
		int pivot = array[high]; // Pivô escolhido é o último elemento
		int i = low - 1; // Índice para os menores elementos

		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++; // Incrementa o índice dos menores elementos
				swap(i, j);
			}
		}
		swap(i + 1, high); // Coloca o pivô na posição correta
		return i + 1; // Retorna o índice do pivô
	}

	private void quickSort(int low, int high) {
		if (low < high) {
			int pivotIndex = partition(low, high); // Particiona o array
			quickSort(low, pivotIndex - 1); // Ordena a metade esquerda
			quickSort(pivotIndex + 1, high); // Ordena a metade direita
		}
	}

	public void sort() {
		quickSort(0, array.length - 1);
	}

	public void printArray() {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		int[] array = {10, 7, 8, 9, 1, 5};
		MyQuickSort myQuickSort = new MyQuickSort(array);
		System.out.println("Array before sorting:");
		myQuickSort.printArray();
		myQuickSort.sort();
		System.out.println("\nArray after sorting:");
		myQuickSort.printArray();
	}
}
