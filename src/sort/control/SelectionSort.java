package sort.control;

public class SelectionSort {

	public static int[] sort(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			int i_smaller = getIndexSmallerNumber(i, A);
			int key = A[i];
			A[i] = A[i_smaller];
			A[i_smaller] = key;
		}
		return A;
	}

	private static int getIndexSmallerNumber(int i, int[] A) {
		int i_smaller = i;
		for (int j = i + 1; j < A.length; j++) {
			if (A[j] < A[i_smaller])
				i_smaller = j;
		}
		return i_smaller;
	}
}
