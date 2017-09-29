package entity.data_structure;

public class Queue {

	private Item head;
	private Item tail;
	private int size;

	public Queue(int[] arr) {
		for (int i = arr.length - 1; i > -1; i--) {
			add(arr[i]);
		}
	}

	public void add(int value) {
		Item item = new Item(tail, null, value);
		if (size > 0)
			tail.setPrevious(item);
		else
			head = item;
		tail = item;
		size++;
	}

	public Integer peek() {
		if (size == 0)
			return null;
		return head.getValue();
	}

	public Integer poll() {
		if (size == 0)
			return null;
		Integer peek = peek();
		Item item = remove(head);
		head = item;
		if (size <= 1)
			tail = item;
		return peek;
	}

	private Item remove(Item item) {
		Item next = item.getNext();
		Item previous = item.getPrevious();
		if (next != null) {
			next.setPrevious(previous);
		}
		if (previous != null) {
			previous.setNext(next);
		}
		size--;
		if (next == null)
			return previous;
		return next;
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
