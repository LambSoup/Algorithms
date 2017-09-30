package graph.control;

public class DagShortestPath {

	public static int[] shortestPaths(int[][] G, int[][] weight, int s) {
		int[] l = TopologicalSort.sort(G, G.length);
		int[] shortest = shortest(G, s);
		int[] pred = pred(G.length);
		for (int u : l) {
			if (G[u] == null)
				continue;
			for (int v : G[u]) {
				shortest = relax(u, v, weight[u][v], shortest, pred);
			}
		}
		return shortest;
	}

	private static int[] relax(int u, int v, int w, int[] shortest, int[] pred) {
		if (shortest[u] + w < shortest[v]) {
			shortest[v] = shortest[u] + w;
			pred[v] = u;
		}
		return shortest;
	}

	private static int[] pred(int n) {
		int[] pred = new int[n];
		for (int i = 0; i < n; i++)
			pred[i] = -1;
		return pred;
	}

	private static int[] shortest(int[][] G, int s) {
		int[] shortest = new int[G.length];
		for (int i = 0; i < G.length; i++) {
			shortest[i] = Integer.MAX_VALUE;
		}
		shortest[s] = 0;
		return shortest;
	}

}
