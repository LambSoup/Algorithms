package graph.control;

import entity.data_structure.Stack;

public class TopologicalSort {

	public static int[] sort(int[][] A, int n) {
		int[] in_degree = in_degree(A, n);
		Stack next = next(n, in_degree);
		int[] result = new int[n];
		int i = 0;
		while (!next.empty()) {
			int u = next.pop();
			result[i] = u;
			i++;
			if (A[u] == null)
				continue;
			for (int v : A[u]) {
				int adjacents = in_degree[v];
				adjacents--;
				if (adjacents == 0)
					next.push(v);
			}
		}
		return result;
	}

	private static Stack next(int n, int[] in_degree) {
		Stack next = new Stack();
		for (int i = 0; i < n; i++) {
			int adjacent = in_degree[i];
			if (adjacent == 0)
				next.push(i);
		}
		return next;
	}

	public static int[] in_degree(int[][] A, int n) {
		int[] in_degree = new int[n];
		for (int[] V : A) {
			if (V == null)
				continue;
			for (int v : V) {
				in_degree[v]++;
			}
		}
		return in_degree;
	}
}
