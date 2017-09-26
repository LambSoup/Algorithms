package sort.control;

public class MergeSort {

	public static int[] sort(int[] A, int p, int r) {
		if (p >= r)
			return A;
		int q = (p + r) / 2;
		A = sort(A, p, q);
		A = sort(A, q + 1, r);

		return merge(A, p, q, r);
	}

	private static int[] merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] B = copy(A, p, q, n1 + 1);
		int[] C = copy(A, q + 1, r, n2 + 1);
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (B[i] <= C[j]) {
				A[k] = B[i];
				i++;
			} else {
				A[k] = C[j];
				j++;
			}
		}
		return A;
	}

	private static int[] copy(int[] A, int p, int q, int length) {
		int[] copy = new int[length];
		for (int i = p; i <= q; i++) {
			copy[i - p] = A[i];
		}
		copy[length - 1] = Integer.MAX_VALUE;
		return copy;
	}
}
