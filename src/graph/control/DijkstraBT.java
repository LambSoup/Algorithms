package graph.control;

public class DijkstraBT {

	private int[] index;
	private Item[] BT;
	private int p;

	public DijkstraBT(int n, int[] shortest) {
		this.BT = new Item[n];
		this.index = new int[n];
		this.p = 0;
		for (int i = 0; i < n; i++) {
			insert(i, shortest[i]);
		}
	}

	public void insert(int node, int key) {
		if (BT.length > p) {
			BT[p] = new Item(node, key);
			index[node] = p;
			BT = minHeapifyBottomUp(p, ((p + 1) / 2) - 1);
			p++;
		}
	}

	public void decreaseKey(int node, int key) {
		int i = index[node];
		Item item = BT[i];
		item.key = key;
		BT = minHeapifyBottomUp(i, i / 2);
	}

	public Integer extractMin() {
		if (p == 0)
			return null;
		Item item = BT[0];
		BT[0] = BT[p - 1];
		BT = minHeapifyTopBottom(0, 1);
		p--;
		index[item.node] = -1;
		return item.node;
	}

	private Item[] minHeapifyBottomUp(int c, int f) {
		if (f < 0 || BT[c].key >= BT[f].key)
			return BT;
		exchange(c, f);
		return minHeapifyBottomUp(f, ((f + 1) / 2) - 1);
	}

	private Item[] minHeapifyTopBottom(int i, int j) {
		int less = j;
		if (j >= p)
			return BT;
		if (j + 1 < p && BT[j + 1].key < BT[j].key)
			less = j + 1;
		if (BT[i].key <= BT[less].key)
			return BT;
		exchange(i, less);
		return minHeapifyTopBottom(less, (less * 2) + 1);
	}

	private Item[] exchange(int i, int j) {
		Item itemJ = BT[j];
		BT[j] = BT[i];
		BT[i] = itemJ;
		index[BT[i].node] = i;
		index[BT[j].node] = j;
		return BT;
	}

	private class Item {
		int node;
		int key;

		public Item(int node, int key) {
			this.node = node;
			this.key = key;
		}
	}

	public boolean empty() {
		return p == 0;
	}
}
