package graph.control;

public class Dijkstra {

	public static int[] minimumPath(int[][] G, int[][] W, int s) {
		int[] shortest = shortest(G.length, s);
		int[] pred = pred(G.length);
		DijkstraBT BT = new DijkstraBT(G.length, shortest);
		while (!BT.empty()) {
			int u = BT.extractMin();
			if (G[u] == null)
				continue;
			shortest = updateAdjacentNodes(G, W, s, shortest, pred, BT, u);
		}
		return shortest;
	}

	private static int[] updateAdjacentNodes(int[][] G, int[][] W, int s, int[] shortest, int[] pred, DijkstraBT BT,
			int u) {
		for (int v : G[u]) {
			int oldValue = shortest[v];
			shortest = relax(u, v, W, shortest, pred);
			if (oldValue > shortest[v]) {
				BT.decreaseKey(v, shortest[v]);
			}
		}
		return shortest;
	}

	private static int[] relax(int u, int v, int[][] W, int[] shortest, int[] pred) {
		int newPath = shortest[u] + W[u][v];
		if (newPath < shortest[v]) {
			shortest[v] = newPath;
			pred[v] = u;
		}
		return shortest;
	}

	private static int[] pred(int n) {
		int[] pred = new int[n];
		for (int i = 0; i < n; i++) {
			pred[i] = -1;
		}
		return pred;
	}

	private static int[] shortest(int n, int s) {
		int[] shortest = new int[n];
		for (int i = 0; i < n; i++) {
			shortest[i] = Integer.MAX_VALUE;
		}
		shortest[s] = 0;
		return shortest;
	}
}
