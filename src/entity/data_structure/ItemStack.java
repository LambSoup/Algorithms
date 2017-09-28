package entity.data_structure;

class ItemStack {

	private ItemStack next;
	private ItemStack previous;
	private int value;

	public ItemStack(ItemStack next, ItemStack previous, int value	) {
		this.next = next;
		this.previous = previous;
		this.value = value;
	}

	public ItemStack() {
	}

	public ItemStack getNext() {
		return next;
	}

	public void setNext(ItemStack next) {
		this.next = next;
	}

	public ItemStack getPrevious() {
		return previous;
	}

	public void setPrevious(ItemStack previous) {
		this.previous = previous;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
