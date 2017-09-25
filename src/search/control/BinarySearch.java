package search.control;

public class BinarySearch {

	private static final int NOT_FOUND = -1;

	public static int search(int[] A, int x, int p, int r) {
		if (p > r)
			return NOT_FOUND;
		int q = (p + r) / 2;
		if (A[q] == x)
			return q;
		else if (A[q] < x) {
			return search(A, x, q + 1, r);
		} else {
			return search(A, x, p, q - 1);
		}
	}
}
