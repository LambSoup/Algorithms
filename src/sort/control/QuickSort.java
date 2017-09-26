package sort.control;

public class QuickSort {

	public static int[] sort(int[] A) {
		return sort(A, 0, A.length - 1);
	}

	private static int[] sort(int[] A, int p, int r) {
		if (p >= r)
			return A;
		int q = partition(A, p, r);
		A = sort(A, p, q - 1);
		A = sort(A, q + 1, r);
		return A;
	}

	private static int partition(int[] A, int p, int r) {
		int q = p;
		for (int u = p; u < r; u++) {
			if (A[u] <= A[r]) {
				A = exchange(A, q, u);
				q++;
			}
		}
		A = exchange(A, q, r);
		return q;
	}

	private static int[] exchange(int[] A, int q, int u) {
		int key = A[q];
		A[q] = A[u];
		A[u] = key;
		return A;
	}
}
