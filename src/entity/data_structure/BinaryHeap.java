package entity.data_structure;

public class BinaryHeap {

	private int[] arr;
	private int p;

	public BinaryHeap(int n) {
		this.arr = new int[n];
		this.p = 0;
	}

	public void insert(int v) {
		if (arr.length > p) {
			arr[p] = v;
			arr = minHeapifyBottomUp(p, ((p + 1) / 2) - 1, arr);
			p++;
		}
	}

	public void decreaseKey(int i) {
		arr[i]--;
		arr = minHeapifyBottomUp(i, i / 2, arr);
	}

	public Integer extractMin() {
		if(p == 0) return null;
		int r = arr[0];
		arr[0] = arr[p - 1];
		arr = minHeapifyTopBottom(0, 1, p, arr);
		p--;
		return r;
	}

	private int[] minHeapifyBottomUp(int c, int f, int[] arr) {
		if (f < 0 || arr[c] >= arr[f])
			return arr;
		arr = exchange(c, f, arr);
		return minHeapifyBottomUp(f, ((f + 1) / 2) - 1, arr);
	}

	private int[] minHeapifyTopBottom(int i, int j, int p, int[] arr) {
		int less = j;
		if (j >= p)
			return arr;
		if (j + 1 < p && arr[j + 1] < arr[j])
			less = j + 1;
		if (arr[i] <= arr[less])
			return arr;
		arr = exchange(i, less, arr);
		return minHeapifyTopBottom(less, (less * 2) + 1, p, arr);
	}

	private int[] exchange(int i, int j, int[] arr) {
		int v = arr[j];
		arr[j] = arr[i];
		arr[i] = v;
		return arr;
	}
}
