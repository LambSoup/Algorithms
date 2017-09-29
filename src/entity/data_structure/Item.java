package entity.data_structure;

class Item {

	private Item next;
	private Item previous;
	private int value;

	public Item(Item next, Item previous, int value	) {
		this.next = next;
		this.previous = previous;
		this.value = value;
	}

	public Item() {
	}

	public Item getNext() {
		return next;
	}

	public void setNext(Item next) {
		this.next = next;
	}

	public Item getPrevious() {
		return previous;
	}

	public void setPrevious(Item previous) {
		this.previous = previous;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
