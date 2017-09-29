package entity.data_structure;

public class Stack {

	private Item head;
	private int size;

	public void push(int value) {
		Item new_head = new Item(null, head, value);
		if (head != null)
			head.setNext(new_head);
		head = new_head;
		size++;
	}

	public Integer peek() throws Exception {
		if (head != null)
			return head.getValue();
		return null;
	}

	public Integer pop() {
		if (head == null)
			return null;
		int value = head.getValue();
		head = remove(head);
		return value;
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
		else
			return next;
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
