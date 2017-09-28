package entity.data_structure;

public class Stack {

	private ItemStack head;
	private int size;

	public void push(int value) {
		ItemStack new_head = new ItemStack(null, head, value);
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

	private ItemStack remove(ItemStack item) {
		ItemStack next = item.getNext();
		ItemStack previous = item.getPrevious();
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
