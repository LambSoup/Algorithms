package sort.control;

public class InsertionSort {

	public static int[] sort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A = sortSubArray(A, i);
		}
		return A;
	}

	private static int[] sortSubArray(int[] A, int i) {
		int j = i - 1;
		int key = A[i];
		while (j > -1 && key < A[j]) {
			A[j + 1] = A[j];
			j--;
		}
		A[j + 1] = key;
		return A;
	}
}
