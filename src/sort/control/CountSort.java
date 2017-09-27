package sort.control;

public class CountSort {

	public static int[] sort(int[] A, int m) {
		int[] equal = equals(A, m);
		int[] less = less(equal, m);
		return rearrange(A, less, m);
	}

	private static int[] rearrange(int[] A, int[] less, int m) {
		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int key = A[i];
			int index = less[key];
			B[index] = key;
			index++;
			less[key] = index;
		}
		return B;
	}
	
	private static int[] less(int[] equals, int m) {
		int[] less = new int[m];
		for (int i = 1; i < m; i++) {
			less[i] = less[i - 1] + equals[i - 1];
		}
		return less;
	}

	private static int[] equals(int[] A, int m) {
		int[] equals = new int[m];
		for (int i = 0; i < A.length; i++) {
			int key = A[i];
			equals[key] += 1;
		}
		return equals;
	}
}
