package sort.control;

public class DigitalSort {

	public static void main(String[] args) {
		String[] arr = new String[] { "X17FS6", "PL4ZQ2", "JI8FR9", "XL8FQ6", "PY2ZR5", "KV7WS9", "JL2ZV3", "K14WR2" };
		for (String code : sort(arr, 6)) {
			System.out.print(code + " ");
		}
	}

	public static String[] sort(String[] A, int s) {
		for (int i = s - 1; i > -1; i--) {
			A = count_sort(A, 36, i);
		}
		return A;
	}

	private static String[] count_sort(String[] A, int m, int order) {
		int[] equals = equals(A, m, order);
		int[] less = less(equals, m);
		return rearrange(A, less, m, order);
	}

	private static String[] rearrange(String[] A, int[] less, int m, int order) {
		String[] B = new String[A.length];
		for (int i = 0; i < A.length; i++) {
			int key = getKeyFromSatelite(A[i], order);
			int index = less[key];
			B[index] = A[i];
			less[key]++;
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

	private static int[] equals(String[] a, int m, int order) {
		int[] equals = new int[m];
		for (int j = 0; j < a.length; j++) {
			int key = getKeyFromSatelite(a[j], order);
			equals[key] += 1;
		}
		return equals;
	}

	private static int getKeyFromSatelite(String satelite, int order) {
		int key = satelite.charAt(order);
		if (key <= 57)
			key -= 48;
		else
			key -= 55;
		return key;
	}
}
